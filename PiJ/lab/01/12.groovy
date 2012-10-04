println "give me a number"
String str = System.console().readLine();
int num = Integer.parseInt(str);

for(int i=1; i<=num; i++){
	for(int j=0; j<i; j++){
		print i;
	}
	println();
}