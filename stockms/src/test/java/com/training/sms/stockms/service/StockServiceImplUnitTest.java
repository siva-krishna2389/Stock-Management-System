package com.training.sms.stockms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainingapps.sms.stockms.dao.IStockRepository;
import com.trainingapps.sms.stockms.dto.CreateStockRequest;
import com.trainingapps.sms.stockms.entities.Stock;
import com.trainingapps.sms.stockms.exception.StockNotFoundException;
import com.trainingapps.sms.stockms.service.StockServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplUnitTest {

	@Mock
	IStockRepository dao;

	@Spy
	@InjectMocks
	StockServiceImpl service;

	
	/**
	 * scenario : find all stock
	 */

	@Test
	public void findAll() {
		List<Stock> list = mock(List.class);
		when(dao.findAll()).thenReturn(list);
		List<Stock> result = service.findAll();
		verify(dao).findAll();
	}

	/**
	 * scenario : find stock for given id
	 */

	@Test
	public void testfindStockDetailsById_1() {

		Long id = 1L;
		Stock stock = mock(Stock.class);
		Optional<Stock> optional = Optional.of(stock);
		when(dao.findById(id)).thenReturn(optional);
		Stock result = service.findStockById(id);
		assertSame(stock, result);
		verify(dao).findById(id);

	}

	/**
	 * scenario : stock not found for given id
	 */

	@Test
	public void testfindStockDetailsById_2() {
		Long id = 1L;
		Optional<Stock> optional = Optional.empty();
		when(dao.findById(id)).thenReturn(optional);
		Executable executable = () -> service.findStockById(id);
		assertThrows(StockNotFoundException.class, executable);
	}

	/**
	 * scenario : stock delete for given id
	 */

	@Test
	public void testremove() {
		Long id = 1L;
		dao.deleteById(id);
	}
}
