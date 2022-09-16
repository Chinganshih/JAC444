

public class Stack {
	
	private static int frontIndex = 0;
	private static int index = 0; 
	private int stackSize = 0;
	private char[] arrStack = null;
	
	//1-argument constructor
	public Stack(String input) {
		stackSize = input.length();
		arrStack = new char[stackSize];
	}

	//check is stack empty
	public boolean empty() {
//		boolean isEmpty = true;
//		
//		
//		for(char arr : arrStack) {
//			if(arr != 0) {
//				isEmpty = false;
//			}
//		}
		
		return (this.stackSize == 0) ? true : false;
	}
	
	//push the new word into arrStack
	public void push(char newWord) {
		arrStack[index] = newWord;
		index++;
	}
	
	
	//pop the last index in arrStack
	public char pop() throws Exception {
		
		if(this.empty()) {
			throw new Exception("Stack is empty!");
		}else {
			index--;
		}
		
		return arrStack[index];
	}
	
	//pop the first index in arrStack
	public char popfront() throws Exception{
		
		if(this.empty()) {
			throw new Exception("Stack is empty!");
		}else {
			frontIndex++;
		}
		
		return arrStack[frontIndex-1];
	}
	
	//get the size of arrStack
	public int getSize() {
		return stackSize;
	}

	//set the size of stack
	public void setLength(int stackSize) {
		this.stackSize = stackSize;
	}

	//get the entire arrStack
	public char[] getArrStack() {
		return arrStack;
	}

	
}
