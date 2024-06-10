package com.training.sms.orderms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.sms.orderms.entities.CreatedOrder;

public interface IOrderRepository extends JpaRepository<CreatedOrder, String> {

	List<CreatedOrder> findByCustomerId(Long customerId);
	
	@Query("from CreatedOrder where createdDate between :startDate and :endDate")
	List<CreatedOrder>findAllBetweenTwoDates(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);


}