println "game on"
boolean gameOver = false;
int win1, win2 = 0;

while(!gameOver){
	//String str = System.console().readLine();
	String str = new File('ps.txt').text
	char p1 = str.substring(0,1);
	char p2 = str.substring(1,2);
 
	switch(p1){
		case 'R':
			if(p2=='P') win2++;
			else if(p2=='S') win1++;
			break;
		case 'P':
			if(p2=='R') win1++;
			else if(p2=='S') win2++;
			break;
		case 'S':
			if(p2=='R') win2++;
			else if(p2=='P') win1++;
			break;
		default:
			println "wrong input"
	}
	if((win1-win2)==3){
		println "p1 wins";
		gameOver = true;
	}
	else if((win1-win2)==-3){
		println "p2 wins";
		gameOver = true;		
	}
}
