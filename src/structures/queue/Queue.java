package structures.queue;

import java.util.Scanner;

class Queue {
	class Node {
		int value;
		Node next = null;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	int size = 0;
	Node first = null;
	Node last = null;
	int value;
	
	public void push(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
			first.next = last;
		}
		else {
			if (last == null) {
				last = node;
				first.next = last;
			}
			else {
				last.next = node;
				last = node;
			}
		}
		size++;
	}
	
	public int pop() {
		value = first.value;
		first = first.next;
		size--;
		return value;
	}
	
	public int front() {
		return first.value;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue queue = new Queue();
		int value;
		while(true) {
			String qString = in.next();
			if (qString.equals("push")) {
				value = in.nextInt();
				queue.push(value);
				System.out.println("ok");
			}
			else if (qString.equals("pop")) {
				System.out.println(queue.pop());
			}
			else if (qString.equals("front")) {
				System.out.println(queue.front());
			}
			else if (qString.equals("clear")) {
				queue.clear();
				System.out.println("ok");
			}
			else if (qString.equals("size")) {
				System.out.println(queue.size());
			}
			else if (qString.equals("exit")) {
				System.out.println("bye");
				break;
			}
		}
		in.close();
	}
}

