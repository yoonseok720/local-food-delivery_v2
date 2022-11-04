package localfooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long payid;
    private Long orderId;
    private Double amount;
    private String status;
}


