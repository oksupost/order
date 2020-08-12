package local;

import local.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload Shipped shipped){
        //주문 시 배송상태값 설정
        Optional<Order> orderOptional = orderRepository.findById(shipped.getOrderId());
        Order order = orderOptional.get();
        order.setStatus(shipped.getStatus());

        orderRepository.save(order);
    }

}
