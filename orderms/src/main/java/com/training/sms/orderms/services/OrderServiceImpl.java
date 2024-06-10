package com.training.sms.orderms.services;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.sms.orderms.dao.IOrderRepository;
import com.training.sms.orderms.dto.CreateOrderRequest;
import com.training.sms.orderms.dto.OrderDetails;
import com.training.sms.orderms.dto.StockDetails;
import com.training.sms.orderms.entities.CreatedOrder;
import com.training.sms.orderms.exceptions.InvalidDateException;
import com.training.sms.orderms.exceptions.OrderNotFoundException;
import com.training.sms.orderms.util.OrderUtil;

@Transactional
@Service
public class OrderServiceImpl implements IOrderServices {
	@Autowired
	private IOrderRepository dao;

	@Autowired
	private OrderUtil util;

	private SecureRandom random = new SecureRandom();

	/**
	 * Method to create an order whith inputs as customerId, list of units ordered.
	 * Date and total amount are auto generated.
	 */
	@Override
	public OrderDetails create(CreateOrderRequest request) {
		CreatedOrder order = new CreatedOrder();
		String newId = generateId();
		order.setOrderId(newId);
		order.setCustomerId(request.getCustomerId());
		Map<Long, Integer> stocks = convert(request.getOrderedStocks());
		order.setOrderedStocks(stocks);
		double totalAmount = 0;
		Set<Long> stockIds = stocks.keySet();
		Map<Long, Double> prices = fetchStockPrices(stockIds);

		for (Long stockId : stockIds) {
			Double price = prices.get(stockId) * (stocks.get(stockId));
			totalAmount = totalAmount + price;
		}
		order.setAmount(totalAmount);
		LocalDate createdDate = LocalDate.now();
		order.setCreatedDate(createdDate);
		CreatedOrder saved = dao.save(order);
		OrderDetails desired = util.toDetails(saved);
		return desired;

	}

	/**
	 * Method to convert key value from String to Long.
	 */
	public Map<Long, Integer> convert(Map<String, Integer> input) {
		Map<Long, Integer> desired = new HashMap<>();
		for (String key : input.keySet()) {
			Long id = Long.parseLong(key);
			int units = input.get(key);
			desired.put(id, units);
		}
		return desired;
	}

	/**
	 * Method to fetch stock prices from the Stock Module.
	 */
	public Map<Long, Double> fetchStockPrices(Collection<Long> ids) {
		Map<Long, Double> map = new HashMap<>();
		for (Long stockId : ids) {
			StockDetails details = util.fetchStocks(stockId);
			map.put(stockId, details.getPrice());
		}
		return map;

	}

	/**
	 * Find order details by order id. Takes one input value which is orderId.
	 * Returns order details.
	 */

	@Override
	public OrderDetails findByOrderId(String orderId) {

		Optional<CreatedOrder> optional = dao.findById(orderId);
		if (!optional.isPresent()) {
			throw new OrderNotFoundException("Order not found.");
		}
		CreatedOrder created = optional.get();
		OrderDetails details = util.toDetails(created);
		return details;
	}

	/**
	 * To get orders from a specific customer using customerId. Takes one input long
	 * value. returns a list of orders placed by the particular customer.
	 */

	@Override
	public List<OrderDetails> ordersByCustomer(Long customerId) {
		List<CreatedOrder> list = dao.findByCustomerId(customerId);
		List<OrderDetails> response = util.toDetailsList(list);
		return response;
	}

	/**
	 * To fetch all the orders list placed between two dates.
	 */
	@Override
	public List<OrderDetails> findOrdersBetween(LocalDate startDate, LocalDate endDate) {
		validateDate(startDate, endDate);
		List<CreatedOrder> orders = dao.findAllBetweenTwoDates(startDate, endDate);
		List<OrderDetails> desired = util.toDetailsList(orders);
		return desired;
	}

	/**
	 * Code to generate random numbers.
	 */
	public String generateId() {
		StringBuffer generated = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			int randomNum = random.nextInt(99);
			generated.append(randomNum);
		}
		String generatedText = generated.toString();
		return generatedText;
	}

	/**
	 * To check the validations of inputs.
	 */
	void validateDate(LocalDate date) {
		LocalDate today = LocalDate.now();
		if (date.isAfter(today)) {
			throw new InvalidDateException("Entered date is invalid");
		}
	}

	void validateDate(LocalDate startDate, LocalDate endDate) {
		validateDate(startDate);
		validateDate(endDate);
		if (endDate.isBefore(startDate)) {
			throw new InvalidDateException("end date is samller than start date");
		}
	}

}
