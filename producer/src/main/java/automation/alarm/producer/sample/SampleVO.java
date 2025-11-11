package automation.alarm.producer.sample;

import java.time.LocalDateTime;

public record SampleVO (
	LocalDateTime timestamp,
	String userAgent,
	String userName
) {

}
