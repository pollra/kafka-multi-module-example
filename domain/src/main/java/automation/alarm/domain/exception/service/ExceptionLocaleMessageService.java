package automation.alarm.domain.exception.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import automation.alarm.domain.exception.entity.DomainException;
import automation.alarm.domain.exception.enumerater.BusinessCode;
import automation.alarm.domain.exception.enumerater.ExceptionCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExceptionLocaleMessageService {

	private final MessageSource messageSource;

	public String getMessage(DomainException domainException) {
		if (domainException.getArguments().length <= 0) {
			return this.getMessage(domainException.getBusinessCode(), domainException.getExceptionCode());
		}
		return this.getMessage(domainException.getBusinessCode(), domainException.getExceptionCode(), domainException.getArguments());
	}

	protected String getMessage(BusinessCode businessCode, ExceptionCode exceptionCode) {
		return messageSource.getMessage(convertMessageProperty(businessCode, exceptionCode), null, LocaleContextHolder.getLocale());
	}

	protected String getMessage(BusinessCode businessCode, ExceptionCode exceptionCode, String[] args) {
		return messageSource.getMessage(convertMessageProperty(businessCode, exceptionCode), args, LocaleContextHolder.getLocale());
	}

	private String convertMessageProperty(BusinessCode businessCode, ExceptionCode exceptionCode) {
		StringBuilder propertyBuilder = new StringBuilder();
		propertyBuilder.append(businessCode.name().toLowerCase());
		propertyBuilder.append('.');
		propertyBuilder.append(exceptionCode.name().toLowerCase());
		return propertyBuilder.toString();
	}
}
