//package tele;

public class SmartPhone extends MobilePhone{
	public SmartPhone(String brand){
		super(brand);
	}

	@Override
	public void call(String number){
		if(number.substring(0,2).equals("00")){
			System.out.println("Calling " + number + " through the internet to save money");
		}
		else{
			super.call(number);
		}
	}

	public void browseWeb(String url){
		System.out.println("browsing "+url);
	}

	public String findPosition(){
		return "LKL";
	}
}