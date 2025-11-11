package automation.alarm.domain.exception.entity;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

public class NotFoundException extends DomainException {

	public NotFoundException(BusinessCode businessCode) {
		super(businessCode, ExceptionCode.NOT_FOUND);
	}

	public NotFoundException(BusinessCode businessCode, String singleMessage) {
		super(businessCode, ExceptionCode.NOT_FOUND, new String[]{singleMessage});
	}
}
