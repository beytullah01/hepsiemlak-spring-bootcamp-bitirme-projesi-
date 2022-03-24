package emlakburada.utilities;

import org.springframework.http.HttpStatus;

public class SuccessResult  extends Result{

	public SuccessResult() {
		super(true);
		
	}
	
	public SuccessResult(String message) {
		
		super(true,message);
	}
	
	public SuccessResult(HttpStatus httpStatus,String message) {
		
		super(httpStatus,message);
		
	}
}
