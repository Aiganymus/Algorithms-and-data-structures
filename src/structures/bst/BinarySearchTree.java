package structures.bst;

class BinarySearchTree {
	class Node {
		int value;
		Node leftChild;
		Node rightChild;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	Node root;
	
	public void insert(int value) {
		Node node = new Node(value);
		if (root == null) root = node;		
		else {
			Node cur = root;			
			while(true) {
				if (value <= cur.value) {
					if (cur.leftChild == null) {
						cur.leftChild = node; 
						break;
					}
					else cur = cur.leftChild;					
				} else {
					if (cur.rightChild == null) {
						cur.rightChild = node; 						
						break;
					} 
					else cur = cur.rightChild;
				}
			}				
		}
	}
	
	public boolean find(int value) {
		if(root == null) return false;
		
		Node cur = root;
		while(true) {
			if(cur == null) return false;
			
			if (value < cur.value) {
				cur = cur.leftChild;				
			} 
			else if (value > cur.value) {
				cur = cur.rightChild;
			}
			else return true;
		}	
	}
	
	public int root() {
		return root.value;
	}
	
	public void delete(int value){
		if (root == null) return;
		
        deleteRec(root, value);
    }

    public void deleteRec(Node root, int value) { 
    	if (value < root.value) deleteRec(root.leftChild, value);
        else if (value > root.value) deleteRec(root.rightChild, value);
        
        else {        	        	
        	//no child
        	if (root.leftChild == null && root.rightChild == null) root = null;
        	
        	//one child 
        	else if (root.leftChild == null) {
        		root = root.rightChild;   
        	} 
        	else if (root.rightChild == null) {
        		root = root.leftChild;
        	}
        	
        	//two children
        	else {        		
        		Node temp = findMin(root.rightChild);
        		root.value = temp.value;
        		deleteRec(root.rightChild, temp.value);
        		
        	}
        }
    }
    
    public Node findMin(Node root) {
    	while(root.leftChild != null) {
    		root = root.leftChild;
    	}
		return root;
    }
   
}
