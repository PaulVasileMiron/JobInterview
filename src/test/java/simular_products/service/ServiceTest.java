package simular_products.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import simular_products.service.impl.Service;
import simular_products.web.model.ProductDetail;

@SpringBootTest
class ServiceTest {

	@MockBean
	private RestTemplate restTemplate;
	
	@Autowired
	private Service service;
	
	private String endpoint = "http://localhost:3001";

	@Test
	void getProductsSimilarTest() {
		String productId = "1";
		String[] list = {"1"};
		ProductDetail expectedProductDetail = new ProductDetail();
		when(restTemplate.getForObject(anyString(), eq(ProductDetail.class))).thenReturn(expectedProductDetail);
		when(restTemplate.getForObject(anyString(), eq(String[].class))).thenReturn(list);


		// Act
		service.getProductSimilar(productId);

		// Assert
		verify(restTemplate, times(1)).getForObject(endpoint + "/product/" + productId, ProductDetail.class);
		verify(restTemplate, times(1)).getForObject(endpoint + "/product/" + productId + "/similarids", String[].class);
	}
	
	@Test
	void getProductsSimilarTest2() {
		String productId = "1";
		when(restTemplate.getForObject(anyString(), eq(String[].class))).thenThrow(ResponseStatusException.class);	

	    assertThrows(ResponseStatusException.class, () -> service.getProductSimilar(productId));
	}
	
	@Test
	void getProductsSimilarTest3() {
		String productId = "1";
		String[] list = {"1"};
		when(restTemplate.getForObject(anyString(), eq(String[].class))).thenReturn(list);
		when(restTemplate.getForObject(anyString(), eq(ProductDetail.class))).thenThrow(ResponseStatusException.class);	

	    assertThrows(ResponseStatusException.class, () -> service.getProductSimilar(productId));
	}
}
