package structures.linkedlist;

public class LinkedList{
    class Node {
        Node prev;
        Node last;
        int value;

        public Node(int value){
            this.value = value;
            prev = last = null;
        }
    }

    Node head;
    int size = 0;
    
    public int getSize() {
        return size;
    }
    
    public LinkedList() {
        head = null;
        head.prev = head.last = head;
    }

    public void insert(int value)
    {
        if (head == null) head = new Node(value);
        else {
            Node temp = head;
            head = new Node(value);
            head.prev = temp;
        }
        size++;
    }

    public void deleteLast(){
        head = head.prev;
    }
    
    public int getLast(){
        return head.value;
    }

    public static void main(String args[])
    {

    }
}