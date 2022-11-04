package localfooddelivery.domain;

import localfooddelivery.domain.배달시작됨;
import localfooddelivery.domain.DeliveryStarted;
import localfooddelivery.domain.쿠폰발행됨;
import localfooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    
    
    
    
    private String userid;
    
    
    
    
    
    private String menu;
    
    
    
    
    
    private String address;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        배달시작됨 배달시작됨 = new 배달시작됨(this);
        배달시작됨.publishAfterCommit();



        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        쿠폰발행됨 쿠폰발행됨 = new 쿠폰발행됨(this);
        쿠폰발행됨.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = StoreApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void orderReceive(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderCancel(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
