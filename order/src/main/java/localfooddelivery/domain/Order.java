package localfooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localfooddelivery.OrderApplication;
import localfooddelivery.domain.OrderCanceled;
import localfooddelivery.domain.Ordered;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String menu;

    private Integer qty;

    private String status;

    private String userId;

    private String address;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        localfooddelivery.external.Payment payment = new localfooddelivery.external.Payment();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(localfooddelivery.external.PaymentService.class)
            .approvePayment(payment);

        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void orderStatusChange(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
