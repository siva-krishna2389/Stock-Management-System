package com.training.sms.orderms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.training.sms.orderms.dto.OrderDetails;
import com.training.sms.orderms.dto.StockDetails;
import com.training.sms.orderms.entities.CreatedOrder;

@Component
public class OrderUtil {

	@Autowired
	private DateUtil dateUtil;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * method to Returns order details as Dto.
	 * 
	 * @param order
	 * @return orderDetails
	 */

	public OrderDetails toDetails(CreatedOrder order) {
		OrderDetails details = new OrderDetails();
		details.setOrderId(order.getOrderId());
		details.setAmount(order.getAmount());
		String dateText = dateUtil.toText(order.getCreatedDate());
		details.setDate(dateText);
		details.setOrderedStocks(order.getOrderedStocks());
		details.setCustomerId(order.getCustomerId());
		return details;
	}

	/**
	 * method to Returns list of orders as sto.
	 * 
	 * @param orders
	 * @return list of orders
	 */

	public List<OrderDetails> toDetailsList(Collection<CreatedOrder> orders) {
		List<OrderDetails> desired = new ArrayList<>();
		for (CreatedOrder order : orders) {
			OrderDetails details = toDetails(order);
			desired.add(details);
		}
		return desired;
	}

	/**
	 * Hitting rest end point of stock module to fetch prices of stock unit using
	 * stockId.
	 * 
	 * @param stockId
	 */

	public StockDetails fetchStocks(Long stockId) {
		String url = "http://localhost:8686/stocks/byid/" + stockId;
		StockDetails response = restTemplate.getForObject(url, StockDetails.class);
		return response;
	}

}