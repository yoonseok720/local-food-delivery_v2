package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long orderId;
    private String menu;
    private Integer qty;
    private String status;
    private String userId;
    private String address;
}


