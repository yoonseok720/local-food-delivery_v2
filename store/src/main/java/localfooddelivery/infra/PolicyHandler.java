package localfooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import localfooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import localfooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired 주문관리Repository 주문관리Repository;
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='결제승인됨'")
    public void whenever결제승인됨_주문정보받음(@Payload 결제승인됨 결제승인됨){

        결제승인됨 event = 결제승인됨;
        System.out.println("\n\n##### listener 주문정보받음 : " + 결제승인됨 + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='결제취소됨'")
    public void whenever결제취소됨_주문취소처리(@Payload 결제취소됨 결제취소됨){

        결제취소됨 event = 결제취소됨;
        System.out.println("\n\n##### listener 주문취소처리 : " + 결제취소됨 + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentApproved'")
    public void wheneverPaymentApproved_OrderReceive(@Payload PaymentApproved paymentApproved){

        PaymentApproved event = paymentApproved;
        System.out.println("\n\n##### listener OrderReceive : " + paymentApproved + "\n\n");


        

        // Sample Logic //
        Order.orderReceive(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentCanceled'")
    public void wheneverPaymentCanceled_OrderCancel(@Payload PaymentCanceled paymentCanceled){

        PaymentCanceled event = paymentCanceled;
        System.out.println("\n\n##### listener OrderCancel : " + paymentCanceled + "\n\n");


        

        // Sample Logic //
        Order.orderCancel(event);
        

        

    }

}


