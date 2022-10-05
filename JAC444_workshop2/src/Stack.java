

public class Stack {
	
	private static int index = 0; 
	private int stackSize = 0;
	private char[] arrStack = null;
	
	//1-argument constructor
	public Stack(int size) {
		stackSize = size;
		arrStack = new char[size];
	}

	//check is stack empty
	public boolean empty() {
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
	

	//get the size of arrStack
	public int getSize() {
		return stackSize;
	}

	//get the entire arrStack
	public char[] getArrStack() {
		return arrStack;
	}

	
}
