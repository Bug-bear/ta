class Point{
	double x;
	double y;
}

class Rectangle{
	Point upLeft;
	Point downRight;
}

Point a = new Point();
Point b = new Point();

a.x=2; a.y=4;
b.x=4; b.y=2;

Rectangle rec = new Rectangle();
rec.upLeft = a;
rec.downRight = b;

println "3rd point coordinate x:"
String str = System.console().readLine();
double x = Double.parseDouble(str);
println "3rd point coordinate y:"
str = System.console().readLine();
double y = Double.parseDouble(str);

Point c = new Point();
c.x=x; c.y=y;

//rec.upLeft.x=2; rec.upLeft.y=4;
//rec.downRight.x=4; rec.downRight.y=2;

if((c.x>=rec.upLeft.x)&&(c.x<=rec.downRight.x)&&(c.y<=rec.upLeft.y)&&(c.y>=rec.downRight.y))
	println "in";
else
	println "out"

//double ab = Math.sqrt(Math.pow((A.x-B.x),2)+Math.pow((A.y-B.y),2));