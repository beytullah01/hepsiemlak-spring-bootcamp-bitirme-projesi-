package emlakburada.utilities;

import org.springframework.http.HttpStatus;

public class Result  {

	private boolean success;
	private String message;
	private HttpStatus httpStatus;
	
	
	public Result() {
		
	
	}
	
	public Result(boolean success) {
		
		this.success=success;
	}
	
	public Result(boolean success,String message) {
		
		this(success);
		this.message=message;
	}
	
	public Result(String message) {
		
		this.message=message;
	}
	
	public Result(HttpStatus httpStatus,String message) {
		
		this(message);
		this.httpStatus=httpStatus;
		
	}
	
	
	
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}


	public boolean isSuccess() {
		
		return this.success;
	}
	public String getmessage() {
		
		return this.message;
	}
}
