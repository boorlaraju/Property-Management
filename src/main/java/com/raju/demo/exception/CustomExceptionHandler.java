package com.raju.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex)
	{
		System.out.println("Business Exception is thrown successfully -->first pust on huthub");
		return new ResponseEntity<List<ErrorModel>>(bex.getErrors(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException mavn)
	{
		List<ErrorModel> errorModelList = new ArrayList<>();
		ErrorModel errorModel=null;
		List<FieldError> fieldErrorList = mavn.getBindingResult().getFieldErrors();
		for(FieldError fe: fieldErrorList)
		{
			errorModel = new ErrorModel();
			errorModel.setCode(fe.getField());
			errorModel.setMessage(fe.getDefaultMessage());
			errorModelList.add(errorModel);
		}
		return new ResponseEntity<List<ErrorModel>>(errorModelList,HttpStatus.BAD_REQUEST);
	}
	

}
