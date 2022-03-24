package emlakburada.utilities;

import org.springframework.http.HttpStatus;

public class SuccessDataResult<T> extends DataResult<T> {

	/**
	 * 
	 */
	


	public SuccessDataResult(T data, String message) {
		super(data,true,message );

	}
	
	
	
	public SuccessDataResult(T data){
		
		super(data,true);
	}
	
	public SuccessDataResult( String message) {
		super(null,true,message );

	}
	
	public SuccessDataResult( T data,HttpStatus httpStatus,String message) {
		
		super(data,httpStatus,message);
		
	}
	

	public SuccessDataResult( ) {
		super(null,true);

	}
	
	
	
}
