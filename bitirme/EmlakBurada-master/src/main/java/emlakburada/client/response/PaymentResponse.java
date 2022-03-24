package emlakburada.client.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
	
	private int paymentId;
	private int orderId;
	private BigDecimal amount;
	private String creditCard;
	private Boolean isPay;
}
