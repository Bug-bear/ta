boolean finished = false;
String searched = "";

while(!finished){
	int ctr = 0;
	int repeated = 0;
	println "give me text"
	String text = System.console().readLine();
	println "which letter to count?"
	char letter = System.console().readLine();
	searched += letter;
	
	for(int i=0; i<searched.length(); i++){
		if(searched.charAt(i)==letter)
			repeated++;
	}
	
	if(repeated>=2){
		println "goodbye";
		finished = true;
	} else{
		for(int i=0; i<text.length(); i++){
			if(text.charAt(i)==letter)
				ctr++;
		}
		println "letter found "+ ctr + " times";
	}
}
