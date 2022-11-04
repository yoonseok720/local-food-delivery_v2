package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private String menu;
    private String address;
    private Long orderId;
    private String status;
    private String userid;
    private Integer qty;
}


