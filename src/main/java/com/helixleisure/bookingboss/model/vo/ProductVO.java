package com.helixleisure.bookingboss.model.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVO {

    private Long id;
    private String name;
    private Integer quantity;
    private Double saleAmount;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
