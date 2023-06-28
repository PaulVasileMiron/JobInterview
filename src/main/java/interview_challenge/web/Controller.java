package interview_challenge.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import interview_challenge.service.IService;
import interview_challenge.web.model.ProductDetail;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {
	
	@Autowired
	private IService service;

    @RequestMapping(value = "/product/{productId}/similar", method = RequestMethod.GET)
    List<ProductDetail> getProductSimular(@PathVariable("productId") String productId) {
    	log.info("Request has been received");
        return service.getProductSimilar(productId);
    }
}
