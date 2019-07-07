package com.helixleisure.bookingboss.model.form;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * ClassName:ProductRetrieveFormWrapper
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
public class ProductRetrieveFormWrapper implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = -748168118151853463L;
	private String id;
	private Instant timestamp;


	private List<ProductRetrieveForm> products;

	public ProductRetrieveFormWrapper() {
	}

	public ProductRetrieveFormWrapper(String id, Instant timestamp, List<ProductRetrieveForm> products) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.products = products;
	}

	public ProductRetrieveFormWrapper(List<ProductRetrieveForm> products) {
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

	public List<ProductRetrieveForm> getProducts() {
		return products;
	}

	public void setProducts(List<ProductRetrieveForm> products) {
		this.products = products;
	}

}

