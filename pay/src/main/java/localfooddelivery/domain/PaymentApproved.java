package localfooddelivery.domain;

import java.util.*;
import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long payid;
    private String orderId;
    private Double amount;
    private String staus;

    public PaymentApproved(Payment aggregate) {
        super(aggregate);
    }

    public PaymentApproved() {
        super();
    }
}
