package com.trainingapps.sms.reportms.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingapps.sms.reportms.dto.CreateReportRequest;
import com.trainingapps.sms.reportms.dto.OrderDetails;
import com.trainingapps.sms.reportms.dto.SalesReportDetails;
import com.trainingapps.sms.reportms.entities.SalesReport;
import com.trainingapps.sms.reportms.exception.InvalidDateException;
import com.trainingapps.sms.reportms.exception.ReportNotFoundException;
import com.trainingapps.sms.reportms.repository.ISalesReportRepository;
import com.trainingapps.sms.reportms.util.DateUtil;
import com.trainingapps.sms.reportms.util.SalesReportUtil;

/*
 * This is a service class and this class is related to service layer
 * this is bean class so objects are stored in Servlet container
 * this is implementation class of sales report service interface
 * */
@Transactional
@Service
public class SalesReportServiceImpl implements ISalesReportService {

	/*
	 * By auto wiring objects the spring will keep object in container and inject
	 * objects when necessary in the project
	 */
	@Autowired
	private SalesReportUtil util;

	@Autowired
	public DateUtil dateUtil;

	@Autowired
	private ISalesReportRepository repository;

	/*
	 * create the sales report when start date and end date are provided
	 */
	@Override
	public SalesReportDetails create(CreateReportRequest request) {
		String startDateText = request.getStartDate();
		LocalDate startDate = dateUtil.toLocalDate(startDateText);
		String endDateText = request.getEndDate();
		LocalDate endDate = dateUtil.toLocalDate(endDateText);
		validateDate(startDate, endDate);
		List<OrderDetails> orders = util.fetchOrders(startDate, endDate);
		double totalSaleAmount = 0;
		Map<Long, Integer> stockMap = new HashMap<>();
		if (orders != null) {
			for (OrderDetails order : orders) {
				totalSaleAmount = totalSaleAmount + order.getAmount();
				Map<Long, Integer> orderedStocks = order.getOrderedStocks();
				for (long stockId : orderedStocks.keySet()) {
					int quantity = orderedStocks.get(stockId);
					if (stockMap.containsKey(stockId)) {
						int iteratedQuantity = orderedStocks.get(stockId);
						int totalQuantity = quantity + iteratedQuantity;
						stockMap.put(stockId, totalQuantity);
					} else {
						stockMap.put(stockId, quantity);
					}
				}
			}
		}
		SalesReport report = new SalesReport();
		report.setTotalSaleAmount(totalSaleAmount);
		report.setSoldStocks(stockMap);
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		LocalDate today = LocalDate.now();
		report.setCreatedDate(today);
		report = repository.save(report);
		return util.toDetails(report);
	}

	/*
	 * fetch the sales report by using the generated report id
	 */
	@Override
	public SalesReport findReportById(Long reportId) {
		Optional<SalesReport> optional = repository.findById(reportId);
		if (!optional.isPresent()) {
			throw new ReportNotFoundException("No such Report is found");
		}
		return optional.get();
	}

	/*
	 * to fetch the sales report details by generated report id related to dto
	 */
	@Override
	public SalesReportDetails findReportDetailsById(Long reportId) {
		SalesReport report = findReportById(reportId);
		return util.toDetails(report);
	}

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
