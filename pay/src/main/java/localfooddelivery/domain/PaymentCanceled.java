package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long payid;
    private Long orderId;
    private Double amount;
    private String status;

    public PaymentCanceled(Payment aggregate){
        super(aggregate);
    }
    public PaymentCanceled(){
        super();
    }
}
