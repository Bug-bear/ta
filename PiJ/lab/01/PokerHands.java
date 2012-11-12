import java.util.*;

public class PokerHands{
	private enum Suits{
		SPADES,
		HEARTS,
		DIAMONDS,
		CLUBS;
	}

	private String getOption(){
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		Suits wawa = Suits.SPADES;
		if(s.equals("clubs")){
			wawa = Suits.CLUBS;
		}
		System.out.println(wawa + " " + wawa.ordinal());
		System.out.println(Suits.valueOf("HEARTS"));
	
		/*
		for(Suits s : Suits.values()){
			System.out.println(s);
		}
		for(int i=0; i<Suits.values().length; i++){
			System.out.println(Suits.values()[i]);
		}
		*/
	}
}