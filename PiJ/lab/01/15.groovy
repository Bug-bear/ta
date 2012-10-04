int toGuess = Math.abs(1000 * Math.random());
int attempts = 0;

boolean bingo = false;

while(!bingo){
	println "try to guess my number"
	String str = System.console().readLine();
	int trial = Integer.parseInt(str);
	attempts++;
	
	if(trial > toGuess)
		println "my number is lower"
	else if(trial < toGuess)
		println "my number is higher"
	else{
		bingo = true;
		println "oh yeah!"
	}
}