package localfooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localfooddelivery.PayApplication;
import localfooddelivery.domain.PaymentApproved;
import localfooddelivery.domain.PaymentCanceled;
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

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void cancelPayment(OrderCanceled orderCanceled) {        
        
        // modified 
        repository().findById(orderCanceled.getOrderId()).ifPresent(payment->{
            if (orderCanceled.getStatus() == "Canceled") {
                payment.setStatus("Canceled");                
                repository().save(payment);        
            }
        });       

    }
}
