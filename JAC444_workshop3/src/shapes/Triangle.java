package shapes;

public class Triangle implements Shape{

	private double bottom;
	private double high;
	private double width;
	
	public Triangle(double bottom, double high, double width) throws ShapeException{
		if(bottom > 0 && high > 0 && width > 0 && (bottom+high) > width) {
			this.bottom = bottom;
			this.high = high;
			this.width = width;
		}else throw new ShapeException("Invalid side(s)!");
		
	}
	
	public double getBottom() {
		return bottom;
	}

	public void setBottom(double bottom) {
		this.bottom = bottom;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double perimeter() {
		return bottom + high + width;
	}
	
	public String toString() {
		return "Triangle {s1=" + this.getBottom() + ", s2=" + this.getHigh() + ", s3=" + this.getWidth() + "} ";
	}
}
