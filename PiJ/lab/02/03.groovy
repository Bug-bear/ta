println "give me sth"
String str = System.console().readLine();
/*
for(int i=0; i<str.length(); i++){
	println str.substring(i,i+1);
}
*/

for(int i=0; i<str.length(); i++){
	if(str.substring(i,i+1)!=" "){
		print str.substring(i,i+1);
	} else{
		println();
	}
}