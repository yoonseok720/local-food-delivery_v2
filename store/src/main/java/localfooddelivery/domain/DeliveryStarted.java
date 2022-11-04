package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private String menu;
    private String address;
    private Long orderId;
    private String status;
    private String userid;
    private Integer qty;

    public DeliveryStarted(Order aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
