package shapes;

public class Circle implements Shape{

	private double radius; 
	
	public Circle(double radius) throws ShapeException {				
		if(radius > 0) {
			this.radius = radius;
		}else throw new ShapeException("Invalid radius!");
	
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public String toString() {
		return "Circle {r=" +  this.getRadius() + "} ";
	}

}
