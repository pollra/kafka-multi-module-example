package automation.alarm.domain.exception.enumerater;

import automation.alarm.domain.web.enumerater.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
	NOT_FOUND		(HttpStatus.NOT_FOUND),
	BAD_REQUEST		(HttpStatus.BAD_REQUEST),
	NOT_IMPLEMENTED	(HttpStatus.NOT_IMPLEMENTED),
	UNAUTHORIZED	(HttpStatus.UNAUTHORIZED),
	NOT_ACCEPTABLE	(HttpStatus.NOT_ACCEPTABLE),
	SERVER_ERROR    (HttpStatus.INTERNAL_SERVER_ERROR);

	private final HttpStatus httpStatus;
}
