println "optimus prime"
println "give me the central"
String str = System.console().readLine();
int centre = Integer.parseInt(str);
int cand1 = centre; 
int cand2 = centre;
boolean finished = false;

while(!finished){
	cand1--;
	cand2++;
	
	boolean prime1 = true; 
	boolean prime2 = true;
	
	for(int j=2; j<cand1; j++){
		if(cand1%j==0){
			prime1 = false;
			break;
		}
	}
	for(int j=2; j<cand2; j++){
		if(cand2%j==0){
			prime2 = false;
			break;
		}
	}
	
	if(prime1 || prime2){
		finished = true;
		if(prime1) println cand1;
		if(prime2) println cand2;
	}
}