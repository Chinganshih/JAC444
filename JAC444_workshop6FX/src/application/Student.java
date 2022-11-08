package application;
import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();
	
	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
		super();
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;				
	}
	
	public Student() {
		super();
	}
	public int getStdID() {
		return stdID;
	}
	public void setStdID(int stdID) {
		this.stdID = stdID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	} 
	
	public String toString() {
		return ("Student ID: " + this.getStdID() + 
				"\nStudent first name: " + this.getFirstName()+
				"\nStudent last name: " + this.getLastName()+
				"\nStudent Courses: " + this.getCourses() + "\n");
	}
	
	
	
	
}
