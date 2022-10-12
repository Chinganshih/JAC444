import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AddStudent {
	
	public static void main(String[] args) {
		
		ArrayList<Student> std = new ArrayList<Student>();
		
		Scanner stdObj = new Scanner(System.in);
		String stdID, firstName, lastName, exit = "";
		
		while(!exit.equalsIgnoreCase("1")) {
			System.out.println("Enter student ID, first name, last name: ");
			stdID = stdObj.nextLine();
			firstName = stdObj.nextLine();
			lastName = stdObj.nextLine();
			
			System.out.println("Enter courses, exit input by typing 'Enter': ");
			String course;
			ArrayList<String> courses = new ArrayList<String>();
			while((course = stdObj.nextLine()) != "") {
				courses.add(course);
			}
			System.out.print("Exit the input(Y-> 1 / N-> 0): ");
			exit = stdObj.next();
			
			Student newStd= new Student(Integer.parseInt(stdID), firstName, lastName, courses);
			std.add(newStd);
			stdObj.nextLine();
			
		}
		stdObj.close();
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream("Studentfile.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(std);
			oos.flush();
			fos.close();
			
		}catch(Throwable e) {
			System.err.println(e);
		}
		
	}
}
