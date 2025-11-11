package automation.alarm.domain.web.enumerater;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpStatus {

	OK(200, "OK"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"),
	NOT_ACCEPTABLE(406, "Not Acceptable"),
	NOT_IMPLEMENTED(501, "Not Implemented"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");

	private final int code;
	private final String reasonPhrase;
}
