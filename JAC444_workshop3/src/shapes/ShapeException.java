package shapes;

public class ShapeException extends Exception{

	private static final long serialVersionUID = 1L;
	private String errorMsg;
	
	ShapeException(){
		super();
	}
	
	ShapeException(String description){
		super(description);
		errorMsg = description;
	}

	public String geterrorMsg() {
		return errorMsg;
	}

	public void setMessage(String message) {
		this.errorMsg = message;
	}
}
