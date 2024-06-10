package com.trainingapps.sms.reportms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.sms.reportms.entities.SalesReport;

/*
 * This is a Repository class and a bean class related to data access 
 * the inbuilt methods of JPA repository are directly in service implementation
 */
public interface ISalesReportRepository extends JpaRepository<SalesReport, Long> {

}
