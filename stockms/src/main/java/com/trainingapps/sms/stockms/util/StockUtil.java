package com.trainingapps.sms.stockms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trainingapps.sms.stockms.dto.StockDetails;
import com.trainingapps.sms.stockms.entities.Stock;



@Component
public class StockUtil {

    public StockDetails toDetails(Stock stock){
    	StockDetails details=new StockDetails();
        details.setId(stock.getId());
        details.setStockName(stock.getStockName());
        details.setUnits(stock.getUnits());
        details.setPrice(stock.getPrice());
        return details;
    }

    public List<StockDetails> toDetailsList(Collection<Stock> stock){
    
        List<StockDetails>desired=new ArrayList<>();
        for(Stock stk:stock){
        	StockDetails details= toDetails(stk); 
           desired.add(details);
        }
       return desired;
    }
}
