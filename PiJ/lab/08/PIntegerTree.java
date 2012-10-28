public class PIntegerTree{
	private PIntegerTreeNode root;
	
	public PIntegerTree(){
		this.root = null;
	}
	
	public PIntegerTree(int num){
		this.root = new PIntegerTreeNode(num);
	}
	
	public PIntegerTree(PIntegerTreeNode p){
		this.root = p;
	}	

	public void add(int num) {
		PIntegerTreeNode node = new PIntegerTreeNode(num);
		if(this.root == null){
			this.root = node;
		}
		else{
			insert(this.root, node);
		}
	}
	
	private void insert(PIntegerTreeNode r, PIntegerTreeNode node){
		if(node.getVal() <= r.getVal()){
			if(r.getLeft() == null){
				r.setLeft(node);
			}
			else{
				insert(r.getLeft(), node);
			}
		} else{
			if(r.getRight() == null){
				r.setRight(node);
			}
			else{
				insert(r.getRight(), node);
			}		
		}
	}


	public boolean contains(int num) {
		return search(this.root, num);
	}
	
	private boolean search(PIntegerTreeNode r, int num){
		if(r == null){
			return false;
		}
		if(r.getVal() == num){
			return true;
		}
		return search(r.getLeft(), num) || search(r.getRight(), num);
	}

	public int getMax(){
		if(this.root == null){
			System.out.println("empty tree");
			return -999;
		}
		else{
			return findMax(this.root);
		}
	}

	private int findMax(PIntegerTreeNode node){
		if(node.getRight() == null){
			return node.getVal();
		}
		else{
			return findMax(node.getRight());
		}
	}
	
	public int getMin(){
		if(this.root == null){
			System.out.println("empty tree");
			return -999;
		}
		else{
			return findMin(this.root);
		}
	}	
	
	private int findMin(PIntegerTreeNode node){
		if(node.getLeft() == null){
			return node.getVal();
		}
		else{
			return findMin(node.getLeft());
		}
	}	
	
	public String toString(){
		//return "[" + convert(this.root) + "]";
		return "[" + convertSimpl(this.root) + "]";
	}
	
	private String convert(PIntegerTreeNode node){
		if(node != null){
			return (node.getVal() + " L[" + convert(node.getLeft()) + "]"
				+ " R[" + convert(node.getRight()) + "]");
		}
		else return "";	
	}
	
	private String convertSimpl(PIntegerTreeNode node){
		String ret = "";
		if(node != null){
			ret += node.getVal() + "";
			if(convertSimpl(node.getLeft()) != null){
				ret += " [" + convertSimpl(node.getLeft()) + "]";
			}
			if(convertSimpl(node.getRight()) != null){
				ret += " [" + convertSimpl(node.getRight()) + "]";
			}
			return ret;
		}
		else{ 
			return null;	
		}
	}	
	
	public int depth(){
		return getDepth(this.root);
	}
	
	private int getDepth(PIntegerTreeNode node){
		if(node.getLeft() == null && node.getRight() == null){
			return 0;
		}
		else if(node.getLeft() == null){
			return 1+getDepth(node.getRight());
		}
		else if(node.getRight() == null){
			return 1+getDepth(node.getLeft());
		}		
		else{
			return 1+Math.max(getDepth(node.getLeft()), getDepth(node.getRight()));
		}		
	}
	
	
	public void remove(int num){
		if(this.root == null){
			System.out.println("empty tree");
			return;
		}
		else{
			this.root = delete(this.root, num);
		}
	}
	
	private PIntegerTreeNode delete(PIntegerTreeNode node, int num){
        if(node != null){
            if(node.getVal() < num){
                node.setRight(delete(node.getRight(), num));
            }
			else if(node.getVal() > num){
                node.setLeft(delete(node.getLeft(), num));
            }
			else{
                if(node.getLeft() == null && node.getRight() == null){ //found in a leaf node, just remove
                    node = null;
                }
				else if(node.getLeft() != null && node.getRight() == null){ //only has left child, replace with it
                    node = node.getLeft();
                }
				else if(node.getRight() != null && node.getLeft() == null){ //only has right child, replace with it
                    node = node.getRight();
                }
				else{ //has both left and right node
                    if(node.getRight().getLeft() == null){ //if its right child is the smallest in that branch
                        node.getRight().setLeft(node.getLeft()); // move its left branch to the left of its right child
                        node = node.getRight(); // replace with its right child
                    }
					else{ //find out the smallest in the right branch and the parent
                        PIntegerTreeNode q, p = node.getRight();
                        while(p.getLeft().getLeft() != null)
                            p = p.getLeft();
                        q = p.getLeft();
                        p.setLeft(q.getRight());
                        q.setLeft(node.getLeft()); // replace
                        q.setRight(node.getRight());
                        node = q;
                    }
                }
            }
        }
        return node;	
	}
	
	
	//my helper
	public void display(){
		peep(this.root);
	}
	
	private void peep(PIntegerTreeNode node){
		if(node != null){
			peep(node.getLeft());
			System.out.print(node.getVal());
			peep(node.getRight());
		}
	}
}