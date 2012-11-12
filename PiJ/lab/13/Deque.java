public interface Deque<T extends Comparable> {
	void append(Dnode<T> d);
	Dnode<T> popFront();
}