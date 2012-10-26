public class PIntegerTreeNode {
	private int value;
	private PIntegerTreeNode left;
	private PIntegerTreeNode right;

	public PIntegerTreeNode(int num){
		this.value = num;
		this.left = null;
		this.right = null;
	}
	
	public int getVal(){
		return this.value;
	}
	
	public void setVal(int num){
		this.value = num;
	}	
	
	public PIntegerTreeNode getLeft(){
		return this.left;
	}
	
	public PIntegerTreeNode getRight(){
		return this.right;
	}	
	
	public void setLeft(PIntegerTreeNode left){
		this.left = left;
	}	
	
	public void setRight(PIntegerTreeNode right){
		this.right = right;
	}		
}