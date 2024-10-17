package com.jsp.car.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.car.exception.CarNotAddedException;
import com.jsp.car.exception.CarNotFoundException;
import com.jsp.car.response.CarResponse;

@ControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler
	public ResponseEntity<CarResponse> handler1(CarNotFoundException e){
		CarResponse response = new CarResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(e.getMessage());
		response.setCar(null);
		response.setCars(null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler
	public ResponseEntity<CarResponse> handler2(CarNotAddedException e){
		CarResponse response = new CarResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(e.getMessage());
		response.setCar(null);
		response.setCars(null);
		return new ResponseEntity<CarResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handler3(MethodArgumentNotValidException e){
		Map<String,String> mapValues = new HashMap<>();
		      List<FieldError> fieldErrors =  e.getBindingResult().getFieldErrors();
		      for(FieldError error : fieldErrors) {
		    	  mapValues.put(error.getField(),error.getDefaultMessage());
		      }
		      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapValues);
	}
	
}
