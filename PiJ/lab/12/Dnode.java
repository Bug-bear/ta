public class Dnode<T extends Comparable>{
	public T value;
	public Dnode<T> left;
	public Dnode<T> right;
	
	public Dnode(T v){
		this.value = v;
		this.left = null;
		this.right = null;
	}
}