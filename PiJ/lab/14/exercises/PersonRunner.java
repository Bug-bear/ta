package exercises;
import java.util.TreeSet;
import java.util.HashSet;

public class PersonRunner {
	public static void main(String[] args) {
		//TreeSet<Person> mySet = new TreeSet<Person>();
		HashSet<Person> mySet = new HashSet<Person>();
		mySet.add(new Person("Sally", "Brown"));
		mySet.add(new Person("Fred", "Kelly"));
		mySet.add(new Person("Bill", "Akins"));
		mySet.add(new Person("Julie", "Wilkins"));
		mySet.add(new Person("James", "Langdon"));
		
		for (Person p : mySet) {
			System.out.println(p);
		}
	}
}