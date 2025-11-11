package automation.alarm.domain.exception.service;

import automation.alarm.domain.exception.entity.*;
import automation.alarm.domain.exception.vo.DomainExceptionResponse;
import automation.alarm.domain.exception.vo.DomainExceptionResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DomainExceptionHandledService {

	private final DomainExceptionResponseBuilder errorResponseBuilder;

	protected DomainExceptionResponse badRequestExceptionHandle(BadRequestException badRequestException) {
		log.error("badRequestExceptionHandle", badRequestException);
		return errorResponseBuilder.build(badRequestException);
	}

	protected DomainExceptionResponse internalServerExceptionHandle(InternalServerException internalServerException) {
		log.error("internalServerExceptionHandle", internalServerException);
		return errorResponseBuilder.build(internalServerException);
	}

	protected DomainExceptionResponse notFoundExceptionHandle(NotFoundException notFoundException) {
		log.error("notFoundExceptionHandle", notFoundException);
		return errorResponseBuilder.build(notFoundException);
	}

	protected DomainExceptionResponse globalExceptionHandle(NotImplementedException domainException) {
		log.error("globalExceptionHandle", domainException);
		return errorResponseBuilder.build(domainException);
	}

	protected DomainExceptionResponse globalExceptionHandle(NotAcceptableException domainException) {
		log.error("globalExceptionHandle", domainException);
		return errorResponseBuilder.build(domainException);
	}

	protected DomainExceptionResponse globalExceptionHandle(DomainException domainException) {
		log.error("globalExceptionHandle", domainException);
		return errorResponseBuilder.build(domainException);
	}
}
