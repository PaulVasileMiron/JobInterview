package simular_products.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import simular_products.service.IService;
import simular_products.web.model.SimilarProducts;

@AutoConfigureMockMvc
@SpringBootTest
class ControllerTest {

	@Mock
	private IService service;
	
	@InjectMocks
	private Controller controller;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private MockMvc mvc;
	
	@BeforeEach
	void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	void getProductSimularTest() throws Exception {
		SimilarProducts list = new SimilarProducts();
		when(service.getProductSimilar(any())).thenReturn(list);
		this.mvc.perform(get("/product/1/similar")).andExpect(status().isOk());
		
	}
	
	
}
