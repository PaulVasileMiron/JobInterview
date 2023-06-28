package interview_challenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import interview_challenge.service.IService;
import interview_challenge.web.model.ProductDetail;
import interview_challenge.web.model.SimilarProducts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Service implements IService {

	@Autowired
	RestTemplate restTemplate;

	public List<ProductDetail> getProductSimilar(String productId) {
		List<ProductDetail> resultList = new ArrayList<>();
		
		SimilarProducts idSimilar = findSimiliarProductId(productId);
		
		if(idSimilar.getListSimilarProductsId() != null || !idSimilar.getListSimilarProductsId().isEmpty()) {
			log.info("Rest Template request to obtain product detail.");
			idSimilar.getListSimilarProductsId().stream().forEach(x -> resultList.add(findProductDetail(x)));
		}
		
		return resultList;
	}

	private ProductDetail findProductDetail(String x) {
		return restTemplate.getForObject("url", ProductDetail.class);
	}

	private SimilarProducts findSimiliarProductId(String productId) {
		log.info("Rest Template request to obtain all id.");
		return restTemplate.getForObject("url", SimilarProducts.class);
	}
	
}
