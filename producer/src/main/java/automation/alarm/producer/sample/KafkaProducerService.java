package automation.alarm.producer.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private static final String TOPIC = "alarm-topic";

    public void sendMessage(SampleVO sampleVO) {
        try {
            String message = objectMapper.writeValueAsString(sampleVO);
            kafkaTemplate.send(TOPIC, message);
            log.info("Kafka 메시지 전송 완료: {}", message);
        } catch (JsonProcessingException e) {
            log.error("메시지 직렬화 실패", e);
            throw new RuntimeException("Kafka 메시지 전송 실패", e);
        }
    }
}
