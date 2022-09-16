import java.util.*;

public class Palindrome {

	public static boolean isPalindrome(Stack stack) throws Exception {
		
//		int match = 0;
//		
//		if(stack.empty()) {
//			throw new Exception("Stack is empty!");
//		}else {
//			for(int i = 0; i < stack.getSize() / 2; i++) {
//				if(stack.popfront() == stack.pop()) {
//					match++;
//				}
//			}
//		}
//		
//		return (match == stack.getSize() / 2) ? true : false;
		
		char[] reverseArr = new char[stack.getSize()];
		for(int i= 0; i < stack.getSize(); i++) {
			reverseArr[i] = stack.pop();
		}
		
		return (Arrays.equals(reverseArr,stack.getArrStack())) ? true : false;
	}
	
	public static String scanner() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//1. receive a string as a command-line argument
		//String givenString = args[0].toString();
		//2. receive a string as a System.in
		String givenString = scanner();
		
		Stack stack = new Stack(givenString);
		char[] input = givenString.toLowerCase().toCharArray();
		
		for(int i = 0; i < stack.getSize(); i++) {
			stack.push(input[i]);
		}
		
		try {
			if(isPalindrome(stack)) {
				System.out.print(givenString + " is a palindrome.");
			}else {
				System.out.print(givenString + " is not a palindrome.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}

}
