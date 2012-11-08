import java.util.*;

public class MobilePhone extends OldPhone{
	private ArrayList<String> record = new ArrayList<String>();
	private int calls = 0;
	
	public MobilePhone(String brand){
		super(brand);
	}
	
	public void call(String number){
		calls++;
		if(calls == 10){
			record.remove(0);
			calls--;
		}
		super.call(number);
		record.add(number);
	}

	public void ringAlarm(String number){
		System.out.println("incoming call from " + number);
	}
	
	public void playGame(String s){
		System.out.println("playing " + s);
	}
	
	public void printLastNumbers(){
		for(int i=0; i<calls; i++){
			System.out.println(record.get(i));
		}
	}
} 