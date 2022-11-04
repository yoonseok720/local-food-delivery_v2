package localfooddelivery.domain;

import localfooddelivery.domain.*;
import localfooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponIssued extends AbstractEvent {

    private Long id;
    private String menu;
    private String address;
    private String orderId;

    public CouponIssued(Order aggregate){
        super(aggregate);
    }
    public CouponIssued(){
        super();
    }
}
