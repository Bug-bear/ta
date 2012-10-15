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

int hex2decimal(String s){
	int sum = 0;
	int dig = 0;
	for(int i=s.length()-1; i>=0; i--){
		if(s.charAt(i).isDigit()){
			dig = Integer.parseInt(s.substring(i,i+1));
		} else{
			switch(s.charAt(i)){
				case 'a':
					dig = 10;
					break;
				case 'b':
					dig = 11;
					break;
				case 'c':
					dig = 12;
					break;
				case 'd':
					dig = 13;
					break;
				case 'e':
					dig = 14;
					break;
				case 'f':
					dig = 15;
					break;
			}
		}
		sum  += dig*Math.pow(2,4*(s.length()-i-1));
	}
	return sum;
}

String decimal2hex(int n){
	String bin = decimal2binary(n);
}

//println binary2decimal("1111111");
//println decimal2binary(256);
println hex2decimal("ffff");