class Point{
	double x;
	double y;
}

Point A = new Point();
Point B = new Point();
Point C = new Point();

A.x=1; A.y=1;
B.x=2; B.y=2;
C.x=4; C.y=4;

double ab = Math.sqrt(Math.pow((A.x-B.x),2)+Math.pow((A.y-B.y),2));