package localfooddelivery.domain;

import localfooddelivery.domain.결제승인됨;
import localfooddelivery.domain.PaymentApproved;
import localfooddelivery.domain.PaymentApproved;
import localfooddelivery.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long payid;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Double amount;
    
    
    
    
    
    private String status;

    @PrePersist
    public void onPrePersist(){


        결제승인됨 결제승인됨 = new 결제승인됨(this);
        결제승인됨.publishAfterCommit();



        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();



        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void cancelPayment(OrderCanceled orderCanceled){

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
