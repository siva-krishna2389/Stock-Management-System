package com.trainingapps.sms.stockms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.sms.stockms.dto.CreateStockRequest;
import com.trainingapps.sms.stockms.dto.StockDetails;
import com.trainingapps.sms.stockms.dto.UpdateStockRequest;
import com.trainingapps.sms.stockms.entities.Stock;
import com.trainingapps.sms.stockms.service.IStockService;
import com.trainingapps.sms.stockms.util.StockUtil;


@Validated
@RequestMapping("/stocks")
@RestController
public class StockRestController {

	@Autowired
	private StockUtil stockUtil;

	@Autowired
	private IStockService service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public StockDetails add(@RequestBody @Valid CreateStockRequest request) {
		StockDetails response = service.add(request);
		return response;
	}

	@GetMapping("/byid/{Id}")
	public StockDetails getStockById(@Min(1) @PathVariable("Id") Long id) {
		StockDetails response = service.findStockDetailsById(id);
		return response;
	}

	@PutMapping("/update")
	public StockDetails updateName(@RequestBody @Valid UpdateStockRequest request) {
		StockDetails response = service.updateStockRequest(request);
		return response;
	}

	@DeleteMapping("/remove/{Id}")
	public String delete(@Min(1) @PathVariable("Id") Long id) {
		service.remove(id);
		return "Stock deleted";

	}

	@GetMapping
	public List<StockDetails> allStock() {
		List<Stock> list = service.findAll();
		List<StockDetails> response = stockUtil.toDetailsList(list);
		return response;
	}

}
