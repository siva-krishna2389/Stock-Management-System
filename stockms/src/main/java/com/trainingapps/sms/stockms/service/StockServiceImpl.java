package com.trainingapps.sms.stockms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.sms.stockms.dao.IStockRepository;
import com.trainingapps.sms.stockms.dto.CreateStockRequest;
import com.trainingapps.sms.stockms.dto.StockDetails;
import com.trainingapps.sms.stockms.dto.UpdateStockRequest;
import com.trainingapps.sms.stockms.entities.Stock;
import com.trainingapps.sms.stockms.exception.StockNotFoundException;
import com.trainingapps.sms.stockms.util.StockUtil;

@Transactional
@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	private IStockRepository dao;
	@Autowired
	private StockUtil stockUtil;

	@Override
	public StockDetails add(CreateStockRequest request) {

		Stock stock = new Stock();
		stock.setStockName(request.getStockName());
		stock.setUnits(request.getUnits());
		stock.setPrice(request.getPrice());
		stock = dao.save(stock);
		StockDetails details = stockUtil.toDetails(stock);
		return details;
	}

	@Override
	public Stock findStockById(Long id) {
		Optional<Stock> optional = dao.findById(id);

		if (!optional.isPresent()) {
			throw new StockNotFoundException("Stock not found for id=" + id);
		}
		return optional.get();
	}

	@Override
	public StockDetails updateStockRequest(UpdateStockRequest request) {

		Stock stock = findStockById(request.getId());
		stock.setUnits(request.getUnits());
		stock.setPrice(request.getPrice());
		stock.setStockName(request.getStockname());
		Stock saved = dao.save(stock);
		StockDetails details = stockUtil.toDetails(saved);
		return details;
	}

	@Override
	public StockDetails findStockDetailsById(Long id) {
		Stock stock = findStockById(id);
		StockDetails details = stockUtil.toDetails(stock);
		return details;
	}

	@Override
	public List<Stock> findAll() {
		List<Stock> list = dao.findAll();
		return list;
	}

	@Override
	public void remove(Long id) {
		dao.deleteById(id);

	}

}
