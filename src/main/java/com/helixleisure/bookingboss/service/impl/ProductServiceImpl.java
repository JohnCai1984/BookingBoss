package com.helixleisure.bookingboss.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.helixleisure.bookingboss.dao.ProductDAO;
import com.helixleisure.bookingboss.model.po.Product;
import com.helixleisure.bookingboss.model.vo.ProductVO;
import com.helixleisure.bookingboss.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ProductServiceImpl
 * @Description: ProductServiceImpl
 * @author: John
 * @date: 2019/7/6
 */
@Service
public class ProductServiceImpl implements ProductService{


	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductVO> insert(List<ProductVO> productVOList) {
		// TODO Auto-generated method stub

		List<Product> productist = productVOList.stream()
				.filter(temp -> temp != null)
				.map(temp -> {
					Product prod = new Product();
					BeanUtils.copyProperties(temp, prod);
					return prod;
				}).collect(Collectors.toList());

		List<Product> productInsertlist = productDAO.insert(productist);

		productVOList = productInsertlist.stream()
				.filter(temp -> temp != null)
				.map(temp -> {
					ProductVO prodVO = new ProductVO();
					BeanUtils.copyProperties(temp, prodVO);
					return prodVO;
				}).collect(Collectors.toList());
		return productVOList;
	}

	@Override
	public List<ProductVO> findProducts(List<Long> productIds) {
		// TODO Auto-generated method stub
		List<Product> productList = productDAO.selectByIds(productIds);

		List<ProductVO> productVOList= new ArrayList<ProductVO>();
		productVOList =	productList.stream()
					.filter(temp -> temp != null)
					.map(temp -> {
						ProductVO prodVO = new ProductVO();
						BeanUtils.copyProperties(temp, prodVO);
						return prodVO;
					}).collect(Collectors.toList());

		return productVOList;
	}
}
