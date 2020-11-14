package br.com.agendasus.notification.email.v1.infrastructure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class SystemExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(SystemExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NotifyException.class)
	public String handleNotifyException(NotifyException e) {
		logger.warn(e.getMessage());
		return e.getMessage();
	}

}
