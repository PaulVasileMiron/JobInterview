package simular_products.web.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SimilarProductsTest {
	@Test
    void testSimilarProducts() {
		ProductDetail pd = new ProductDetail();
        List<ProductDetail> expectedList = new ArrayList<>();
        expectedList.add(pd);

        SimilarProducts similarProducts = new SimilarProducts();
        similarProducts.setListSimilarProduct(expectedList);

        assertEquals(expectedList, similarProducts.getListSimilarProduct());
    }
}
