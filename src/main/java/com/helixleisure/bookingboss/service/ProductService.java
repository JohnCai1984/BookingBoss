package com.helixleisure.bookingboss.service;

import java.util.List;
import com.helixleisure.bookingboss.model.vo.ProductVO;


public interface ProductService{

	 List<ProductVO> insert(List<ProductVO> productVOList);
	 List<ProductVO> findProducts(List<Long> productIds);
}
