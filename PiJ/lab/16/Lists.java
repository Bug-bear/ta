import java.util.*;

public class Lists {

public static void main(String[] args) {
String  ar[]={"india","pakistan","UK","Japan","Korea"};
ArrayList list=new ArrayList();
list.add(ar[0]);
list.add(ar[1]);
list.add(ar[2]);
list.add(ar[3]);
list.add(ar[4]);

int mid = (list.size()-0)/2;
List list1=list.subList(0, mid+1);
List list2=list.subList(mid+1,list.size());

System.out.println(list+"   ");
System.out.println(list1+"   ");
System.out.println(list2+"   ");
}
}