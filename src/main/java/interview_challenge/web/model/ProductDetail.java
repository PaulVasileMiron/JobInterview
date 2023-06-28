package interview_challenge.web.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDetail {
	private String id;
	private String name;
	private BigDecimal price;
	private boolean availability;
}
