package automation.alarm.consumer.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleListener {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "alarm-topic", groupId = "alarm-consumer-group")
    public void consumeAlarm(String message) {
        try {
            log.info("Received Kafka message: {}", message);

            JsonNode jsonNode = objectMapper.readTree(message);
            String timestamp = jsonNode.get("timestamp").asText();
            String userAgent = jsonNode.get("userAgent").asText();
            String userName = jsonNode.get("userName").asText();

            log.info("Processed alarm - timestamp: {}, userAgent: {}, userName: {}",
                timestamp, userAgent, userName);

            // 여기에 알람 처리 로직을 추가하세요
            // 예: 데이터베이스 저장, 외부 API 호출, 알림 전송 등
            processAlarm(timestamp, userAgent, userName);

        } catch (Exception e) {
            log.error("Failed to process Kafka message: {}", message, e);
        }
    }

    private void processAlarm(String timestamp, String userAgent, String userName) {
        // 실제 알람 처리 로직 구현
        log.info("Processing alarm for user: {} at {}", userName, timestamp);
        // TODO: 실제 비즈니스 로직 추가
    }
}
