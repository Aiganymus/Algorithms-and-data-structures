package sis.brackets;

import java.util.Scanner;

class Brackets {
	static class Stack {
		class Node {
			char value;
			Node prev = null;
			
			public Node(char value) {
				this.value = value;
			}
		}
		
		int size = 0;
		Node top = null;	
		
		public void push(char value) {
			Node node = new Node(value);
			if(top == null) {
				top = node;
			} else {
				node.prev = top;
				top = node;
			}
			size++;
		}
		
		public void pop() {
			top = top.prev;
			size--;	
		}
		
		public char back() {
			return top.value;
		}
		
		public boolean empty() {
			return size == 0;
		}
	}

	public static boolean checkBrackets(String str) {
		Stack stack = new Stack();
		char c;
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);  
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} 
			
			else if(!stack.empty()) {
				if ((c == ')' && stack.back() == '(') ||
					(c == '}' && stack.back() == '{') ||
					(c == ']'&& stack.back() == '[')) {
					stack.pop();
				} 
				else return false;
			} 
			
			else return false;
		}
		return stack.empty();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();		
		
		if(checkBrackets(str)) System.out.println("yes");
		else System.out.println("no");
	}
}
