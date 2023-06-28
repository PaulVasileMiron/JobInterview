package interview_challenge.service;

import java.util.List;

import interview_challenge.web.model.ProductDetail;

public interface IService {

	List<ProductDetail> getProductSimilar(String productId);

}
