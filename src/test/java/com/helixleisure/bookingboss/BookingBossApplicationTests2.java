package com.helixleisure.bookingboss;

import com.helixleisure.bookingboss.model.form.ProductCreationForm;
import com.helixleisure.bookingboss.model.form.ProductRetrieveForm;
import com.helixleisure.bookingboss.model.form.ProductRetrieveFormWrapper;
import com.helixleisure.bookingboss.model.vo.ProductWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingBossApplicationTests2 extends AbstractTest{

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getProducts() throws Exception {
		//		String retJson = HttpUtils.postMethodJson("http://205.252.40.160:8000/api/questiongenerator", params);
		String uri = "/product/list.json";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ProductWrapper prodWrapper = super.mapFromJson(content, ProductWrapper.class);
		assertTrue(prodWrapper.getProducts().size()>0);
	}


	@Test
	public void putProducts() throws Exception {
		String uri = "/product/put.json";
		ProductCreationForm product = new ProductCreationForm();
		product.setName("Ginger");
		product.setQuantity(180);
		product.setSaleAmount(200d);

		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertTrue(content, "Product is created successfully");
	}


}


