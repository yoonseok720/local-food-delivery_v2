package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String menu;
    private String address;
    private String orderId;
    private String status;

    public DeliveryStarted(Order aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
