package com.helixleisure.bookingboss;

import com.helixleisure.bookingboss.model.form.ProductCreationForm;
import com.helixleisure.bookingboss.model.form.ProductCreationFormWrapper;
import com.helixleisure.bookingboss.model.form.ProductRetrieveForm;
import com.helixleisure.bookingboss.model.form.ProductRetrieveFormWrapper;
import com.helixleisure.bookingboss.model.vo.ProductWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
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
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BookingBossApplicationTests{

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getProducts(){
		String uri = "/product/list.json";
		String uuid =  UUID.randomUUID().toString().replace("-", "");
		Instant timestamp = Instant.now();

		List<ProductRetrieveForm> prdRtrFormList =  new ArrayList<ProductRetrieveForm>();
		ProductRetrieveForm prdRtrForm = new ProductRetrieveForm();
		prdRtrForm.setId(4L);
		prdRtrFormList.add(prdRtrForm);
		prdRtrForm = new ProductRetrieveForm();
		prdRtrForm.setId(0L);
		prdRtrFormList.add(prdRtrForm);
		prdRtrForm = new ProductRetrieveForm();
		prdRtrForm.setId(1L);
		prdRtrFormList.add(prdRtrForm);

		ProductRetrieveFormWrapper prdRtrFormWrapper = new ProductRetrieveFormWrapper(uuid,timestamp,prdRtrFormList);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ProductRetrieveFormWrapper> requestEntity = new HttpEntity<ProductRetrieveFormWrapper>(prdRtrFormWrapper, headers);

		ResponseEntity<ProductWrapper> response = restTemplate.exchange(
				uri,
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<ProductWrapper>(){});

		HttpStatus status = response.getStatusCode();
		assertEquals(HttpStatus.OK, status);
		assertTrue(response.getBody().getProducts().size() == 2);
	}

	@Test
	public void putProducts() throws Exception {
		String uri = "/product/put.json";

		String uuid =  UUID.randomUUID().toString().replace("-", "");
		Instant timestamp = Instant.now();

		ProductCreationForm product = new ProductCreationForm();
		product.setName("Ginger");
		product.setQuantity(180);
		product.setSaleAmount(200d);

		List<ProductCreationForm> prdCreFormList =  new ArrayList<ProductCreationForm>();
		prdCreFormList.add(product);

		ProductCreationFormWrapper prodCreFormWrapper = new ProductCreationFormWrapper(uuid, timestamp, prdCreFormList);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ProductCreationFormWrapper> requestEntity = new HttpEntity<ProductCreationFormWrapper>(prodCreFormWrapper, headers);

		ResponseEntity<ProductWrapper> response = restTemplate.exchange(
				uri,
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<ProductWrapper>(){});
		HttpStatus status = response.getStatusCode();
		assertEquals(HttpStatus.OK, status);
		assertTrue(response.getBody().getProducts().size() == 1);
	}
}


