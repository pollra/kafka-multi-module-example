package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class NotImplementedException extends DomainException {
	
	public NotImplementedException(BusinessCode businessCode) {
		super(businessCode, ExceptionCode.NOT_IMPLEMENTED);
	}
}
