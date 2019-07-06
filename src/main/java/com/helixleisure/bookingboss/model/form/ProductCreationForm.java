package com.helixleisure.bookingboss.model.form;

import javax.validation.constraints.NotEmpty;

/**
 * ClassName:ProductRetrieveForm
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author John Cai
 * @version
 * @since Version 1.0
 * @Date 30 Jun 2019
 *
 * @see
 */
public class ProductCreationForm {

	private String name;
	private Integer quantity;
	private Double saleAmount;

	public ProductCreationForm() {
	}

	public ProductCreationForm(String name, Integer quantity, Double saleAmount) {
		this.name = name;
		this.quantity = quantity;
		this.saleAmount = saleAmount;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}
}