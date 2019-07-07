package com.helixleisure.bookingboss.model.form;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * ClassName:ProductCreationFormWrapper
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
public class ProductCreationFormWrapper implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = -748168118151853463L;
	private String id;
	private Instant timestamp;
	private List<ProductCreationForm> products;

	public ProductCreationFormWrapper() {
	}

	public ProductCreationFormWrapper(String id, Instant timestamp, List<ProductCreationForm> products) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.products = products;
	}

	public ProductCreationFormWrapper(List<ProductCreationForm> products) {
		super();
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public List<ProductCreationForm> getProducts() {
		return products;
	}

	public void setProducts(List<ProductCreationForm> products) {
		this.products = products;
	}

}

