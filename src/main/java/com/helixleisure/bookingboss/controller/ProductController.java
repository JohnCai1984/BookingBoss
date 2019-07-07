package com.helixleisure.bookingboss.controller;

import com.helixleisure.bookingboss.model.form.ProductCreationForm;
import com.helixleisure.bookingboss.model.form.ProductCreationFormWrapper;
import com.helixleisure.bookingboss.model.form.ProductRetrieveForm;
import com.helixleisure.bookingboss.model.form.ProductRetrieveFormWrapper;
import com.helixleisure.bookingboss.model.vo.ProductVO;
import com.helixleisure.bookingboss.model.vo.ProductWrapper;
import com.helixleisure.bookingboss.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @ClassName: ProductController
 * @Description: ProductController
 * @author: John
 * @date: 2019/7/6
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	   
    @PostMapping("/list.json")
    @ResponseBody
    public ProductWrapper retrieveProduct(@RequestBody ProductRetrieveFormWrapper prodRetrieveFormWrapper) {

        LOGGER.info("Into method ProductController.retrieveProduct...");
        LOGGER.info("The received request id and timestamp are:"+prodRetrieveFormWrapper.getId()+","+prodRetrieveFormWrapper.getTimestamp());

        List<ProductRetrieveForm> products = prodRetrieveFormWrapper.getProducts();

        List<Long> productIds = products.stream()
                                .map(temp -> {
                                    return temp.getId();
                                }).collect(Collectors.toList());

        List<ProductVO> productList = productService.findProducts(productIds);
        ProductWrapper productWrapper = new ProductWrapper();
        String uuid =  UUID.randomUUID().toString().replace("-", "");
        Instant timestamp = Instant.now();
    	productWrapper.setId(uuid);
    	productWrapper.setTimestamp(timestamp);
        productWrapper.setProducts(productList);

        return productWrapper;

    }

    @PostMapping("/put.json")
    @ResponseBody
    public ProductWrapper saveProduct(@RequestBody ProductCreationFormWrapper prodCreationFormWrapper) {

        LOGGER.info("Into method ProductController.saveProduct...");
        LOGGER.info("The received request id and timestamp is:"+prodCreationFormWrapper.getId()+","+prodCreationFormWrapper.getTimestamp());

        List<ProductCreationForm> products = prodCreationFormWrapper.getProducts();
        List<ProductVO> productVOList = products.stream()
                .map(temp -> {
                    ProductVO productVO = new ProductVO();
                    BeanUtils.copyProperties(temp,productVO);
                    return productVO;
                }).collect(Collectors.toList());
        List<ProductVO> productList =  productService.insert(productVOList);

        String uuid =  UUID.randomUUID().toString().replace("-", "");
        Instant timestamp = Instant.now();

        ProductWrapper productWrapper = new ProductWrapper();
        productWrapper.setId(uuid);
        productWrapper.setTimestamp(timestamp);
        productWrapper.setProducts(productList);

        return productWrapper;
    }
}
