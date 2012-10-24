public class IntegerTreeNode {
	int value;
	IntegerTreeNode left;
	IntegerTreeNode right;

	public IntegerTreeNode(int num){
		this.value = num;
		this.left = null;
		this.right = null;
	}

	public void add(int newNumber) {
		if (newNumber > this.value) {
			if (right == null) {
				right = new IntegerTreeNode(newNumber);
			} else {
				right.add(newNumber);
			}
		} else {
			if (left == null) {
				left = new IntegerTreeNode(newNumber);
			} else {
				left.add(newNumber);
			}
		}
	}

	public boolean contains(int n) {
		if (n == this.value) {
			return true;
		} else if (n > this.value) {
			if(this.right != null)
				return right.contains(n);
			else
				return false;
		} else{
			if(this.left != null)
				return left.contains(n);
			else
				return false;
		}
	}
	
	public int getMax(){
		if(this.right == null){
			return this.value;
		}
		else{
			return this.right.getMax();
		}
	}
	
	public int getMin(){
		if(this.left==null && this.right==null){
			return this.value;
		}
		else{
			return this.left.getMin();
		}
	}	

	public String toString1(IntegerTreeNode start){
		if(start != null){
			//return ("[" + start.value+" L[" + toString1(start.left) + "]"
				//+ " R[" + toString1(start.right) + "]]");
			return (start.value+" L[" + toString1(start.left) + "]"
				+ " R[" + toString1(start.right) + "]");
		}
		else return "";
	}

	public String toString2(){
		if(this.left == null && this.right == null){
			//return ("[" + this.value + " L[]R[]]");	
			return (this.value + " L[]R[]");	
		}
		else if(this.left == null){
			return ("[" + this.value+" L[]"
				+ " R[" + this.right.toString2() + "]]");	
		}
		else if(this.right == null){
			return ("[" + this.value+" L[" + this.left.toString2() + "]"
				+ " R[]]");
		}
		else{
			return ("[" + this.value+" L[" + this.left.toString2() + "]"
				+ " R[" + this.right.toString2() + "]]");	
		}
	}
	
	public String toStringSimpl(){
		if(this.left == null && this.right == null){
			//return ("[" + this.value + "]");	
			return (this.value + "");	
		}
		else if(this.left == null){
			return ("[" + this.value+"[" + this.right.toStringSimpl() + "]]");	
		}
		else if(this.right == null){
			return ("[" + this.value+"[" + this.left.toStringSimpl() + "]]");
		}		
		else{
			return ("[" + this.value+" [" + this.left.toStringSimpl() + "]"
				+ " [" + this.right.toStringSimpl() + "]]");
		}
	}	
	
	public int depth1(IntegerTreeNode start, int deep){
		if(start != null){
			return  Math.max(1+deep + depth1(start.left, deep), 1+deep+depth1(start.right,deep));
		}
		else return -1;	
	}
	
	public int depth2(int deep){
		if(this.left == null && this.right == null){
			return deep;
		}
		else if(this.left == null){
			return this.right.depth2(deep+1);
		}
		else if(this.right == null){
			return this.left.depth2(deep+1);
		}		
		else{
			return Math.max(this.left.depth2(deep+1), this.right.depth2(deep+1));
		}	
	}
	
	/*
	public void remove1(IntegerTreeNode start, int num){
		if(start.value == num){
			if(start.left == null && start.right ==null){
			}
			else{
				start.value = start.getMax();
				start.left = 
			}				
		}
		else{
			remove(start.left, num);
			remove(start.right, num);
		}
	}
	*/
	
	//my helper
	public void peep(IntegerTreeNode start){
		if(start != null){
			peep(start.left);
			System.out.println(start.value);
			peep(start.right);
		}
	}
}