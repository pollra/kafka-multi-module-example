package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class UnauthorizedException extends DomainException {

	public UnauthorizedException() {
		super(BusinessCode.AUTHENTICATION, ExceptionCode.UNAUTHORIZED);
	}

	public UnauthorizedException(String singleMessage) {
		super(BusinessCode.AUTHENTICATION, ExceptionCode.UNAUTHORIZED, new String[]{singleMessage});
	}
}
