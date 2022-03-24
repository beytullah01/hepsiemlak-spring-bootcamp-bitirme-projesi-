package emlakburada.utilities;

import org.springframework.http.HttpStatus;

public class ErrorResult  extends Result{

	public ErrorResult () {
		super(false);
		
	}
	
	public ErrorResult(HttpStatus httpStatus,String message) {
		
		super(httpStatus,message);
		
	}
	
	public ErrorResult (String message) {
		
		super(false,message);
	}
}