int binary2decimal(String s){
	int sum = 0;
	for(int i=s.length()-1; i>=0; i--){
		int dig = Integer.parseInt(s.substring(i,i+1));
		//print dig;
		sum  += dig*Math.pow(2,(s.length()-i-1));
	}
	return sum;
}

String decimal2binary(int n){
	String remainder = "";
	int result = n;
	while(result!=1){
		remainder = Integer.toString(result%2) + remainder;
		result = result/2;
	}
	remainder = Integer.toString(result)+remainder;
	return remainder;
}

//println binary2decimal("1111111");
println decimal2binary(256);