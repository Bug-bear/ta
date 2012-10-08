println "give me the 1st number"
String str = System.console().readLine();
double a = Double.parseDouble(str);
println "give me the 2nd number"
str = System.console().readLine();
double b = Double.parseDouble(str);
println "what do you want to do? (1: +, 2: - , 3: *, 4: /)"
str = System.console().readLine();
int op = Integer.parseInt(str);

switch(op){
	case 1:
		println a + b;
		break;
	case 2:
		println a - b;
		break;
	case 3:
		println a * b;
		break;
	case 4:
		println a / b;
		break;
	default:
		println "invalid operator"
		break;
}