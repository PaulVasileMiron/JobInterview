package interview_challenge.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import interview_challenge.service.IService;
import interview_challenge.web.model.ProductDetail;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Service implements IService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${resttemplate.endpoint}")
	private String endpoint;

	public List<ProductDetail> getProductSimilar(String productId) {
		List<ProductDetail> resultList = new ArrayList<>();
		
		String[] strList = findSimiliarProductId(productId);
		
		if(strList != null && strList.length != 0) {
			log.info("Rest Template request to obtain product detail.");
			List<String> idSimilar = Arrays.asList(strList);
			idSimilar.forEach(x -> resultList.add(findProductDetail(x)));
		}
		
		return resultList;
	}

	private ProductDetail findProductDetail(String x) {
		
		return restTemplate.getForObject(endpoint + "/product/"+x, ProductDetail.class);
	}

	private String[] findSimiliarProductId(String productId) {
		log.info("Rest Template request to obtain all id.");
		return restTemplate.getForObject(endpoint + "/product/"+ productId +"/similarids", String[].class);
	}
	
}
