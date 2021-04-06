package com.jaeguinblog.I.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.jaeguinblog.I.dto.ResponseDto;

@ControllerAdvice //어느 곳에서든 여기로 올수 있게 설정해줌.
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)//ill~ception 대신 쓰면 더 넓은 범위가 exception 된다.
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()); // 500
	}
}
