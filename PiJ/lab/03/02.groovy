println "give me sth"
String str = System.console().readLine();
int i = 0;
String first = "";
String second = "";
String op = "";
//String remainder = str;

while(i<str.length()){
	if(str.charAt(i).isDigit()){
		first += str.charAt(i);
	} else{
		op = str.charAt(i);
		second = str.substring(i+1);
		break;
	}
	i++;
}

println first;
println op;
println second;