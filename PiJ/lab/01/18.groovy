double sum = 0;
boolean finished = false;
/*
println "how many terms?"
String str = System.console().readLine();
int term = Integer.parseInt(str);


for(int i=0; i<term; i++){
	sum += 4* Math.pow(-1,i)/(2*i + 1);
}
*/

int i = 0;
while(!finished){
	sum += 4* Math.pow(-1,i)/(2*i + 1);
	finished = (((int)sum*100) == 314)
	i++;
}

println i;
println sum;
