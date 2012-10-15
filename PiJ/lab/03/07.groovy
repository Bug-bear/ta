println "give me sth"
String str = System.console().readLine();
boolean yes = true;

for(int i=0; i<str.length(); i++){
	if(str.charAt(i)!=str.charAt(str.length()-1-i)){
		yes = false;
		break;
	}
}

println yes;