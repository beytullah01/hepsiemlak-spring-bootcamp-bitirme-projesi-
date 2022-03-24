package com.example.emlakburadaadverts.util;

import org.springframework.http.HttpStatus;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data,false,message );

	}
	
	public ErrorDataResult(T data){
		
		super(data,false);
	}
	
	public ErrorDataResult( String message) {
		super(null,false,message );

	}
	

	public ErrorDataResult( ) {
		super(null,false);

	}

	public ErrorDataResult(HttpStatus httpStatus, String message) {
		
		super(null, httpStatus,message);
	}
	
}