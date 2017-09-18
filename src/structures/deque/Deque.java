package structures.deque;

import java.util.Scanner;

class Node {
	int value;
	Node next = null;
	Node prev = null;
	
	public Node(int value) {
		this.value = value;
	}
}

class Deque {
	int size = 0;
	Node first = null;
	Node last = null;
	int value;
	
	public void push_front(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
			first.next = last;
		}
		else {
			node.next = first;
			first.prev = node;
			first = node;	
		}
		size++;
	}
	
	public void push_back(int value) {
		Node node = new Node(value);
		if (last == null) {
			last = node;
			last.prev = first;
		}
		else {
			last.next = node;
			node.prev = last;
			last = node;	
		}
		size++;
	}
	
	public int pop_front() {
		value = first.value;
		first = first.next;
		first.prev = null;
		size--;
		return value;
	}
	
	public int pop_back() {
		value = last.value;
		last = last.prev;
		last.next = null;
		size--;
		return value;
	}
	
	public int front() {
		return first.value;
	}
	
	public int back() {
		return last.value;
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
		Deque deque = new Deque();
		int value;
		while(true) {
			String qString = in.next();
			if (qString.equals("push_front")) {
				value = in.nextInt();
				deque.push_front(value);
				System.out.println("ok");
			}
			else if (qString.equals("push_back")) {
				value = in.nextInt();
				deque.push_back(value);
				System.out.println("ok");
			}
			else if (qString.equals("pop_front")) {
				System.out.println(deque.pop_front());
			}
			else if (qString.equals("pop_back")) {
				System.out.println(deque.pop_back());
			}
			else if (qString.equals("front")) {
				System.out.println(deque.front());
			}
			else if (qString.equals("back")) {
				System.out.println(deque.back());
			}
			else if (qString.equals("clear")) {
				deque.clear();
				System.out.println("ok");
			}
			else if (qString.equals("size")) {
				System.out.println(deque.size());
			}
			else if (qString.equals("exit")) {
				System.out.println("bye");
				break;
			}
		}
		in.close();
	}
}



