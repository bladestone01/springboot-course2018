package org.boot.course.global;

import org.boot.course.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 当发现BizException之时，系统会同意处理，给出合适异常提示。
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	public ResponseEntity<String> handleBizException(BizException e) {
		log.info("catch the bizException:" + e.getMessage() + "," + e.getErrorCode());
		return new ResponseEntity<>("订单操作异常，请检查后重试! (" + e.getMessage() + "/" + e.getErrorCode() + ")", HttpStatus.OK);
	}
	
 	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInteralError(Exception e) {
		log.info("catch exception:" + e.getMessage() );
		return new ResponseEntity<>("订单操作异常，请检查后重试! (" + e.getMessage() + ")", HttpStatus.OK);
	} 
}
