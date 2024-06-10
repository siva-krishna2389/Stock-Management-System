package com.trainingapps.sms.cartms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateCartRequest {

	
	@Min(1)
	@NotNull
	private Long customerId;

	public Long getCustomerId() {return customerId;}

	public void setCustomerId(Long customerId) {this.customerId = customerId;}

}
