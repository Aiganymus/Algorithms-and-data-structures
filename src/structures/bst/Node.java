package structures.bst;

class Node {
	int value;
	Node leftChild;
	Node rightChild;
	Node parent;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node clone() {
		Node node = new Node(value);
		node.leftChild = leftChild;
		node.rightChild = rightChild;
		node.parent = parent;
		return node;
	}
}
