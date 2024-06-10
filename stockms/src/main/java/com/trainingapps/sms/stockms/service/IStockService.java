package com.trainingapps.sms.stockms.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.sms.stockms.dto.CreateStockRequest;
import com.trainingapps.sms.stockms.dto.StockDetails;
import com.trainingapps.sms.stockms.dto.UpdateStockRequest;
import com.trainingapps.sms.stockms.entities.Stock;

@Validated
public interface IStockService {

	StockDetails add(@Valid CreateStockRequest request);

	StockDetails updateStockRequest(@Valid UpdateStockRequest request);

	Stock findStockById(@Min(1) Long id);

	StockDetails findStockDetailsById(@Min(1) Long id);

	List<Stock> findAll();

	void remove(@Min(1) Long id);

	
}
