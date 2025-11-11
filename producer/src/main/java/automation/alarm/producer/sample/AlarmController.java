package automation.alarm.producer.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/alarms")
@RequiredArgsConstructor
public class AlarmController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<String> sendAlarm(@RequestBody SampleVO sampleVO) {
        kafkaProducerService.sendMessage(sampleVO);
        return ResponseEntity.ok("Alarm sent successfully");
    }

    @GetMapping("/test")
    public ResponseEntity<String> sendTestAlarm() {
        SampleVO testData = new SampleVO(
            LocalDateTime.now(),
            "Mozilla/5.0 Test Agent",
            "test-user"
        );
        kafkaProducerService.sendMessage(testData);
        return ResponseEntity.ok("Test alarm sent successfully");
    }
}
