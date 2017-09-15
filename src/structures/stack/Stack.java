package structures.stack;

import java.util.Scanner;

class Node {
	int value;
	Node prev = null;
	
	public Node(int value) {
		this.value = value;
	}
}

class Stack {
	int size = 0;
	Node top = null;	
	
	public void push(int value) {
		Node node = new Node(value);
		if(top == null) {
			top = node;
		} else {
			node.prev = top;
			top = node;
		}
		size++;
	}
	
	public int pop() {
		int value = top.value;
		top = top.prev;
		size--;
		return value;		
	}
	
	public int back() {
		return top.value;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		top = null;
		size = 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack stack = new Stack();
		int value;
		while(true) {
			String qString = in.next();
			if (qString.equals("push")) {
				value = in.nextInt();
				stack.push(value);
				System.out.println("ok");
			}
			else if (qString.equals("pop")) {
				System.out.println(stack.pop());
			}
			else if (qString.equals("back")) {
				stack.back();
				System.out.println(stack.back());
			}
			else if (qString.equals("clear")) {
				stack.clear();
				System.out.println("ok");
			}
			else if (qString.equals("size")) {
				stack.size();
				System.out.println(stack.size());
			}
			else if (qString.equals("exit")) {
				stack.size();
				System.out.println("bye");
				break;
			}
		}
		in.close();
	}

}

