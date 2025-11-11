package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class InternalServerException extends DomainException {

	public InternalServerException(BusinessCode businessCode) {
		super(businessCode, ExceptionCode.SERVER_ERROR);
	}
}
