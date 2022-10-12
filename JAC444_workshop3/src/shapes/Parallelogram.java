package shapes;

public class Parallelogram implements Shape{

	private double length;
	private double width;
	
	public Parallelogram(double length, double width) throws ShapeException {
		if(length > 0 && width > 0) {
			this.length = length;
			this.width = width;
		}else throw new ShapeException("Invalid side(s)!");
		
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double perimeter() {
		return 2 * length + 2 * width;
	}
	
	public String toString() {
		return "Parallelogram {w=" + this.getLength() + ", h=" + this.getWidth() + "} ";
	}
}
