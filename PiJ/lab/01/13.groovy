println "prime up to 1000"

for(int i=2; i<=1000; i++){
	boolean prime = true;
	for(int j=2; j<i; j++){
		if(i%j==0){
			prime = false;
			break;
		}
	}
	if(prime)
		println i;
}