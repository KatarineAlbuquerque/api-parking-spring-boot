package me.dio.web.parking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.v3.oas.annotations.Hidden;
import me.dio.web.parking.exception.DataListNullException;
import me.dio.web.parking.exception.DataNegativeException;
import me.dio.web.parking.exception.DataNullException;
import me.dio.web.parking.exception.IdNullException;

@ControllerAdvice
@Hidden
public class DataAdiviceController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNullException.class)
	public ResponseEntity<Object> errorNull() {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Check the form fields.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(DataNegativeException.class)
	public ResponseEntity<Object> errorNumberNegative() {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Enter positive values. Ex: 15.89");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(IdNullException.class)
	public ResponseEntity<Object> errorIdNull() {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "The ID does not exist!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(DataListNullException.class)
	public ResponseEntity<Object> listNull() {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "There is no data to display!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
