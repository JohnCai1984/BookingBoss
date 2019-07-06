package com.helixleisure.bookingboss.model.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;


import java.time.Instant;


/**
 * ClassName:ProductWrapper
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
public class ProductWrapper implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -748168118151853463L;
	private String id;
	private Instant timestamp;
    private List<ProductVO> products;


	public ProductWrapper() {
	}
	
	public ProductWrapper(String id, Instant timestamp, List<ProductVO> products) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.products = products;
	}

	public ProductWrapper( List<ProductVO> products) {
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

	public List<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}

}

