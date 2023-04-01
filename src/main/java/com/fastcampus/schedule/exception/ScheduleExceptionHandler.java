package com.fastcampus.schedule.exception;

import static com.fastcampus.schedule.exception.constant.ErrorCode.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ScheduleExceptionHandler {

	@ExceptionHandler(ScheduleException.class)
	public ScheduleErrorResponse handlerException(ScheduleException e, HttpServletRequest request) {
		log.error("errorCode : {}, url : {}, message : {}",
				  e.getErrorCode(), request.getRequestURI(), e.getMessage());
		return ScheduleErrorResponse.builder()
									.errorCode(e.getErrorCode())
									.message(e.getMessage())
									.build();
	}

	@ExceptionHandler(Exception.class)
	public ScheduleErrorResponse handlerException(Exception e, HttpServletRequest request) {
		log.error("url : {}, message : {}", request.getRequestURI(), e.getMessage());
		return ScheduleErrorResponse.builder()
									.errorCode(INVALID_REQUEST)
									.message(INVALID_REQUEST.getMessage())
									.build();
	}
}
