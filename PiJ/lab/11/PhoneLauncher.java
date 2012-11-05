import tele.SmartPhone;
import tele.RestrictedSmartPhone;
//import tele.*;

public class PhoneLauncher {
	public static void main(String[] args) {
		PhoneLauncher launcher = new PhoneLauncher();
		launcher.launch();
	}
	
	public void launch() {
		SmartPhone sp = new SmartPhone("moto");
		sp.call("111");
		sp.call("222");
		sp.ringAlarm("333");
		sp.playGame("contra");
		sp.printLastNumbers();
		System.out.println();
		for(int i=4; i<12; i++){
			sp.call(i+""+i+i);
		}
		sp.printLastNumbers();
		System.out.println();
		sp.browseWeb("google");
		System.out.println(sp.findPosition());
		System.out.println();
		sp.call("00861062");
		System.out.println();
		System.out.println(sp.getBrand());
		System.out.println();
		
		SmartPhone res = new RestrictedSmartPhone("nokia");
		res.call("666");
		res.call("00777");
		res.printLastNumbers();
		res.playGame("racer");
		System.out.println(res.getBrand());
	}
}