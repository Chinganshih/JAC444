import java.util.*;

public class Palindrome {

	public static boolean isPalindrome(String givenString) throws Exception {
		
		Stack stack = new Stack(givenString.length());
		char[] input = givenString.toLowerCase().toCharArray();
		char[] reverseArr = new char[stack.getSize()];
		
		for(int j = 0; j < stack.getSize(); j++) {
			stack.push(input[j]);
		}
		
		for(int i= 0; i < stack.getSize(); i++) {
			reverseArr[i] = stack.pop();
			
		}
				
		return (Arrays.equals(reverseArr,stack.getArrStack())) ? true : false;
	}
	

	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String[] givenString = new String[args.length];
		for(int i = 0; i < args.length; i++) {
			givenString[i] = args[i].toString();
			try {
				if(isPalindrome(givenString[i])) {
					System.out.println(givenString[i] + " is a palindrome.");
				}else {
					System.out.println(givenString[i] + " is not a palindrome.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
						
	}

}
