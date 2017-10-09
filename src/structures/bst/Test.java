package structures.bst;

class Test {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		for(int i = 0; i < 20; i++) {
			System.out.println((i * 43 + 31) % 10);
			System.out.println("endterm");
			tree.add((i * 4 + 31) % 10);
		}
		
		
//		System.out.println(tree.root.rightChild);
	}

}
