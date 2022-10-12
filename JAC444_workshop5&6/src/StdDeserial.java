import java.io.*;
import java.util.ArrayList;

public class StdDeserial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> stdList = new ArrayList<Student>();
		
		try {
			FileInputStream fis = new FileInputStream("Studentfile.out");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			stdList = (ArrayList) ois.readObject();
			fis.close();
		}catch(Throwable e) {
			System.err.println(e);
		}
		
		for(Student std: stdList) {
			System.out.println(std);
		}
	}

}
