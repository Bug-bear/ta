public class Name{
	public String getInitials(String fullName) {
	String result = "";
	String[] words = fullName.split(" ");
	for (int i = 0; i < words.length; i++) {
		String nextInitial;
		if(words[i].length()>0)
			nextInitial = "" + words[i].charAt(0);
		else
			continue;
		result = result + nextInitial.toUpperCase();
		System.out.println(words[i] + " " + words[i].length());
	}
	return result;
	}
	
	public static void main(String[] args){
		Name name = new Name();
		String input = "Peng  Du";
		String output = name.getInitials(input);
		String expected = "PD";
		//System.out.println(output);
	}
}