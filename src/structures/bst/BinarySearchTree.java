package structures.bst;

class BinarySearchTree {
	Node root;
	
	public void add(int value) {
		Node node = new Node(value);
		if (root == null) root = node;
		
		else {
			Node cur = root;
			
			while(cur != null) {
				if (value <= cur.value) {
					if(cur.leftChild == null) {
						cur.leftChild = node;
						node.parent = cur;
					} 
					else cur = cur.leftChild;					
				} else {
					if(cur.rightChild == null) {
						cur.rightChild = node; 
						node.parent = cur;
						cur = null;
					} 
					else cur = cur.rightChild;
				}
			}				
		}
	}
	
	public boolean find(int value) {
		Node cur = (Node) root.clone();
		
		while(cur != null) {
			if (value < cur.value) {
				cur = cur.leftChild;				
			} 
			else if (value > cur.value) {
				cur = cur.rightChild;
			}
			else return true;
		}
		return false;	
	}
	
	public int root() {
		return root.value;
	}
	
}
