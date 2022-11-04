package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long orderId;
    private String userid;
    private String menu;
    private String address;
    private String qty;
    private String status;
}


