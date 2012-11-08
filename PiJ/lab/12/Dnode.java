public class Dnode<T extends Comparable>{
	public T value;
	public Dnode left;
	public Dnode right;
	
	public Dnode(T v){
		this.value = v;
		this.left = null;
		this.right = null;
	}
}