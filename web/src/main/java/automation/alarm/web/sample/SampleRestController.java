package automation.alarm.web.sample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SampleRestController {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/api/sample" )
	public String sampleApi(SampleRequest sampleRequest) {
		log.info("Sample API called with userAgent: {}, userName: {}", sampleRequest.userAgent(), sampleRequest.userName());
		// Example Kafka message sending
		String message = "Sample API accessed by " + sampleRequest.userName();
		kafkaTemplate.send("sample-topic", message)
			.thenAccept(result -> log.info("Message sent to Kafka: {}", result.toString()))
			.exceptionally(throwable -> {
				log.error("Failed to send message to Kafka: {}", throwable.getMessage());
				return null;
			});
		return "Hello, " + sampleRequest.userName() + "! Your user agent is " + sampleRequest.userAgent();
	}
}
