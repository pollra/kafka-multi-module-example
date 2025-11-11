package automation.alarm.domain.exception.entity;

import java.util.Arrays;

import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;

import automation.alarm.domain.web.enumerater.HttpStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public abstract class DomainException extends RuntimeException {

	private BusinessCode businessCode = BusinessCode.DEFAULT;

	private ExceptionCode exceptionCode = ExceptionCode.BAD_REQUEST;

	private HttpStatus httpStatus = this.exceptionCode.getHttpStatus();

	private String[] arguments = new String[]{};

	public DomainException(BusinessCode businessCode, ExceptionCode exceptionCode) {
		super(businessCode.name() + '.' + exceptionCode.name());
		this.businessCode = businessCode;
		this.exceptionCode = exceptionCode;
		this.httpStatus = exceptionCode.getHttpStatus();
	}

	public DomainException(BusinessCode businessCode, ExceptionCode exceptionCode, String[] arguments) {
		// 예시: USER.NOT_FOUND.[arg1, arg2]
		super(businessCode.name() + '.' + exceptionCode.name() + '.' + Arrays.toString(arguments));
		this.businessCode = businessCode;
		this.exceptionCode = exceptionCode;
		this.httpStatus = exceptionCode.getHttpStatus();
		this.arguments = arguments;
	}

	public DomainException(BusinessCode businessCode) {
		throw new NotImplementedException(businessCode);
	}
}
