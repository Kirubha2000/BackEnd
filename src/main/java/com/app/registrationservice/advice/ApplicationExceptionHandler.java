package com.app.registrationservice.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.registrationservice.exception.EmailAlreadyExistException;
import com.app.registrationservice.exception.PasswordMismatchException;
import com.app.registrationservice.exception.PhoneNumberAlreadyExistsException;



@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ExceptionHandler(EmailAlreadyExistException.class)
	public Map<String, String> handleBuisnessxception(EmailAlreadyExistException ex) {

		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	@ExceptionHandler(PasswordMismatchException.class)
	public Map<String, String> handleBuisnessxception(PasswordMismatchException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	@ExceptionHandler(PhoneNumberAlreadyExistsException.class)
	public Map<String, String> handleBuisnessxception(PhoneNumberAlreadyExistsException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	

}
