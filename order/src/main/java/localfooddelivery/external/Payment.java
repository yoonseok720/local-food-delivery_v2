package localfooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long payid;
    private Long orderId;
    private Integer amount;
    private String status;
}


