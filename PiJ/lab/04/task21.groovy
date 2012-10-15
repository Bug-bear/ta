class Point{
	int x;
	int y;
}
//Thismethodincrementstheintby1and
//movesthepointtotheright
void increment(Point point,int n){
	n=n+1;
	point.x=point.x+1;
	point=null;
	println"Attheendofthemethod..."
	println"Theintegeris"+n;
	println"Thepointis"+point;
}
//Programexecutionstartshere
Point myPoint=new Point();
myPoint.x=0;
myPoint.y=0;
int myInt=0;
println "Theintegerisnow"+myInt;
println "Thepointisnow"+myPoint.x+","+myPoint.y;
println "Callingmethodincrement(Point,int)..."
increment(myPoint,myInt);
println "Theintegerisnow"+myInt;
println "Thepointisnow"+myPoint.x+","+myPoint.y;