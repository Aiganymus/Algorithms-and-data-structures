package structures.bst;

class Test {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		for(int i = 0; i < 10; i++) {
			tree.insert((i * 43 + 31) % 10);
//			System.out.println((i * 43 + 31) % 10);
		}
		
		tree.delete(3);
		System.out.println("///"+ tree.root.rightChild.leftChild.value);
	}

}
