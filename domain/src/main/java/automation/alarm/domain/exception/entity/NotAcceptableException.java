package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class NotAcceptableException extends DomainException {

	public NotAcceptableException(BusinessCode businessCode) {
		super(businessCode, ExceptionCode.NOT_ACCEPTABLE);
	}

	public NotAcceptableException(BusinessCode businessCode, String singleMessage) {
		super(businessCode, ExceptionCode.NOT_ACCEPTABLE, new String[]{singleMessage});
	}
}
