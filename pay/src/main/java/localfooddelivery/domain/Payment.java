package localfooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localfooddelivery.PayApplication;
import localfooddelivery.domain.PaymentApproved;
import localfooddelivery.domain.PaymentCanceled;
import localfooddelivery.domain.결제승인됨;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payid;

    private Long orderId;

    private Double amount;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();

        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        결제승인됨 결제승인됨 = new 결제승인됨(this);
        결제승인됨.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void cancelPayment(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
}
