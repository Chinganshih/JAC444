package shapes;

public class Square implements Shape{

	private double length;
	
	public Square(double length) throws ShapeException{
		if(length > 0) {
			this.length = length;
		}else throw new ShapeException("Invalid side!");
		
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public double perimeter() {
		return 4 * length;
	}
	
	public String toString() {
		return "Square {s=" + this.getLength() + "} ";
	}
}
