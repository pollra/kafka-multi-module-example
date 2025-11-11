package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class BadRequestException extends DomainException {

	public BadRequestException(BusinessCode businessCode) {
		super(businessCode, ExceptionCode.BAD_REQUEST);
	}

	public BadRequestException(BusinessCode businessCode, String singleMessage) {
		super(businessCode, ExceptionCode.BAD_REQUEST, new String[]{singleMessage});
	}
}
