package simular_products.web.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * Class ProductDetail
 * @author Paul Vasile Miron
 */
@Getter
@Setter
public class ProductDetail {
	private String id;
	private String name;
	private BigDecimal price;
	private boolean availability;
}
