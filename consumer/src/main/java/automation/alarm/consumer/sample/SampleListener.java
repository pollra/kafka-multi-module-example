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
            log.info("Kafka 메시지 수신: {}", message);

            JsonNode jsonNode = objectMapper.readTree(message);
            String timestamp = jsonNode.get("timestamp").asText();
            String userAgent = jsonNode.get("userAgent").asText();
            String userName = jsonNode.get("userName").asText();

            log.info("알람 처리 완료 - timestamp: {}, userAgent: {}, userName: {}",
                timestamp, userAgent, userName);

            // 예: 데이터베이스 저장, 외부 API 호출, 알림 전송 등
            processAlarm(timestamp, userAgent, userName);

        } catch (Exception e) {
            log.error("Kafka 메시지 처리 실패: {}", message, e);
        }
    }

    private void processAlarm(String timestamp, String userAgent, String userName) {
        log.info("사용자 알람 처리 중 - 사용자: {}, 시간: {}", userName, timestamp);
    }
}
