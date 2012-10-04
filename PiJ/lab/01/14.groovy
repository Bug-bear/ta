println "up to 1000 prime"
boolean finished = false;
int ctr = 0;
int num = 1;

while(!finished){
	num++;
	boolean prime = true;
	
	for(int j=2; j<num; j++){
		if(num%j==0){
			prime = false;
			break;
		}
	}
	if(prime){
		println num;
		ctr++;
		if(ctr==1000)
			finished = true;
	}
}