package com.trainingapps.sms.stockms.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.sms.stockms.entities.Stock;

public interface IStockRepository extends JpaRepository<Stock, Long>{

	void deleteById(Long id);

	
}
