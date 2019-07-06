package com.helixleisure.bookingboss.model.form;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

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

public class ProductRetrieveForm implements Serializable {


	private static final long serialVersionUID = -748168118151853463L;

	@NotEmpty(message = "Product ID must be mandatory!")
	private Long id;

	public ProductRetrieveForm() {
		this.setId(id);
	}
	public ProductRetrieveForm(@NotEmpty(message = "Product ID is mandatory!") Long id) {
		this.setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}