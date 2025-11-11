package automation.alarm.domain.exception.vo;

public record DomainExceptionResponse(
	String statusCode,
	String businessCode,
	String[] targets,
	String message
) { }
