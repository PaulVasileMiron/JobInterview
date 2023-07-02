package simular_products.web.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ProductDetailTest {
	@Test
    void testProductDetail() {
        String expectedId = "1";
        String expectedName = "Product1";
        BigDecimal expectedPrice = new BigDecimal("10.0");
        boolean expectedAvailability = true;

        ProductDetail product = new ProductDetail();
        product.setId(expectedId);
        product.setName(expectedName);
        product.setPrice(expectedPrice);
        product.setAvailability(expectedAvailability);

        assertEquals(expectedId, product.getId());
        assertEquals(expectedName, product.getName());
        assertEquals(0, expectedPrice.compareTo(product.getPrice()));
        assertEquals(expectedAvailability, product.isAvailability());
    }
}
