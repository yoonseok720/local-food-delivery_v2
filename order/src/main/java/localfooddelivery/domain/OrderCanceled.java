package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long orderId;
    private String menu;
    private Integer qty;
    private String status;

    public OrderCanceled(Order aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
}
