Target tar = new Target(3);

tar.init();

int[] coordinates = new int[3];

Boolean finished = false;
while(!finished){
	println "shoot!"
	String str;
	for(int i=0; i<3; i++){
		println "give me coordinate " + (i+1); 
		str = System.console().readLine();
		coordinates[i] = Integer.parseInt(str);
	}
	
	Result result = tar.fire(coordinates[0],coordinates[1],coordinates[2]);
	
	if(result == Result.HIT){
		finished = true;
	}
}