package tele;

public class RestrictedSmartPhone extends SmartPhone{
	public RestrictedSmartPhone(String brand){
		super(brand);
	}

	public void playGame(String s){
		System.out.println("playing disabled :(");
	}
}