public class TreeTest{
	public static void main(String[] args){
		IntegerTreeNode treeRoot = new IntegerTreeNode(6);
		
		
		treeRoot.add(9);
		
		treeRoot.add(5);
		treeRoot.add(3);
		treeRoot.add(11);
		treeRoot.add(8);
		treeRoot.add(12);
		
		
		treeRoot.peep(treeRoot);
		/*
		System.out.println("contains 1 ? " + treeRoot.contains(1));
		System.out.println("contains 2 ? " + treeRoot.contains(2));
		System.out.println("contains 44 ? " + treeRoot.contains(44));
		System.out.println("contains 0 ? " + treeRoot.contains(0));
		System.out.println("contains 19 ? " + treeRoot.contains(19));
		System.out.println("contains 38 ? " + treeRoot.contains(38));
		System.out.println("contains 6 ? " + treeRoot.contains(6));
		System.out.println("contains 8 ? " + treeRoot.contains(8)); //not there
		System.out.println();
		*/
		
		System.out.println("Max is: " + treeRoot.getMax() + " and Min is: " + treeRoot.getMin());
		
		System.out.println("[" + treeRoot.toString1(treeRoot) + "]");
		System.out.println(treeRoot.toString2());
		System.out.println(treeRoot.toStringSimpl());
		System.out.println();
		
		System.out.println(treeRoot.depth1(treeRoot,0));
		System.out.println(treeRoot.depth2(0));
		
	}
}