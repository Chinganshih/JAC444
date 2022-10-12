package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	private static Shape shapes[];
	private static int numberOfshapes = 0;

	//dynamically resize the array of shapes  
	public static void growArray() {
		
		Shape temp[] = new Shape[numberOfshapes + 1];
		
		for(int i = 0 ; i < numberOfshapes ; i++) {
			temp[i] = shapes[i];
		}
		shapes = temp;
	}
	
	//Filter which shape (Circle, Square, Rectangle, Parallelogram, Triangle)
	public static void shapeFilter(String[] tokens) throws ShapeException{
		
		try {
			//your code
			if(tokens[0].equalsIgnoreCase("circle") && tokens.length < 3){
				double radius = Double.valueOf(tokens[1]);
				Circle circle = new Circle(radius);	
				growArray();
				shapes[numberOfshapes] = circle;
				numberOfshapes++;
				
			}else if(tokens[0].equalsIgnoreCase("square") && tokens.length < 3) {
				double length = Double.valueOf(tokens[1]);
				Square square = new Square(length);
				growArray();
				shapes[numberOfshapes] = square;
				numberOfshapes++;
				
			}else if(tokens[0].equalsIgnoreCase("rectangle") && tokens.length < 4) {
				double length = Double.valueOf(tokens[1]);
				double width = Double.valueOf(tokens[2]);
				Rectangle rectangle = new Rectangle(length, width);
				growArray();
				shapes[numberOfshapes] = rectangle;
				numberOfshapes++;
				
			}else if(tokens[0].equalsIgnoreCase("parallelogram") && tokens.length < 4) {
				double length = Double.valueOf(tokens[1]);
				double width = Double.valueOf(tokens[2]);
				Parallelogram parallelogram = new Parallelogram(length, width);
				growArray();
				shapes[numberOfshapes] = parallelogram;
				numberOfshapes++;
				
			}else if(tokens[0].equalsIgnoreCase("triangle") && tokens.length < 5) {
				double bottom = Double.valueOf(tokens[1]);
				double high = Double.valueOf(tokens[2]);
				double width = Double.valueOf(tokens[3]);
				Triangle triangle = new Triangle(bottom, high, width);
				growArray();
				shapes[numberOfshapes] = triangle;
				numberOfshapes++;
			}
		}catch(ShapeException e) {
			System.out.println(e.geterrorMsg());
		}
	}
	
	public static void readFile(String fileName) throws ShapeException{
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String s;
			while ((s = br.readLine()) != null) {
			String[] tokens = s.split(",");
			
			//Determine which shape belongs to 
			shapeFilter(tokens);		
		}
		}catch(IOException e) {
			throw new ShapeException("Fail to open the file!");
		}

	}

	public static void main(String[] args) throws ShapeException {
		// TODO Auto-generated method stub

		String fileName = "shapes.txt";
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");

		readFile(fileName);
		System.out.println();
		System.out.println(numberOfshapes + " shapes were created:");
		
		for(int i = 0; i < numberOfshapes; i++) {
			System.out.printf(shapes[i].toString() + "perimeter = %.5f\n\n", shapes[i].perimeter());
		}
	}

}
