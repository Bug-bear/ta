import java.util.*;

public class HashedSetRunner{
	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");
		set.add("eee");
		set.add("fff");
		set.add("ggg");
		set.add("hhh");
		set.add("iii");
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");
		set.add("eee");
		set.add("fff");
		set.add("ggg");
		set.add("hhh");
		set.add("iii");
		
		for(String str : set){
			System.out.println(str);
		}
	}
}