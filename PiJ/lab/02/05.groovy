println "give me a short string"
String shor = System.console().readLine();
println "give me sth longer"
String text = System.console().readLine();

int ctr = 0;
boolean found = true;

for(int i=0; i<=(text.length()-shor.length()); i++){
	found = true;
	for(int j=0; j<shor.length(); j++){
		if(shor.charAt(j)!=text.charAt(i+j)){
			found = false;
			break;
		}
	}
	if(found) ctr++;
}

println ctr;