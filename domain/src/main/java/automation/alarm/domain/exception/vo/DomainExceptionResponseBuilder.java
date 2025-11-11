package automation.alarm.domain.exception.vo;

import automation.alarm.domain.exception.entity.DomainException;
import automation.alarm.domain.exception.service.ExceptionLocaleMessageService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainExceptionResponseBuilder {

	private final ExceptionLocaleMessageService exceptionLocaleMessageService;

	public DomainExceptionResponse build(DomainException domainException) {
		String message = exceptionLocaleMessageService.getMessage(domainException);
		return new DomainExceptionResponse(
			domainException.getExceptionCode().name(),
			domainException.getBusinessCode().name(),
			domainException.getArguments(),
			message
		);
	}
}
