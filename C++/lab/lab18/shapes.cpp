/* Example of inheritance from an abstract base class.  Different shape
   classes use the same interface specified as pure virtual in the base
   class Shape.
*/

#include <iostream>
#include <iomanip>
#include <string>
#include <vector>

using namespace std;

class Shape		// abstract base class
{ public:
	virtual double getarea() const = 0;
	virtual bool regular() const = 0;
	string getname() const { return name; }   // functions in an abstract base class do not   
						  // all have to be pure virtual, though they may be
  protected:
	Shape(string nm) : name(nm) {}            // Shape has data, so needs a constructor, but only
						  // derived classes will call it, so it need not be public
  private:
	string name;
};

// Definitions not needed for pure virtual functions.

class Circle : public Shape
{ public:
	Circle(double r) : Shape(name), rad(r) {}
	virtual double getarea() const { return rad * rad * pi; }
	virtual bool regular() const { return true; }
 private:
	double rad;
	static const double pi;
	static const string name;
};

const double Circle::pi = 3.1415;
const string Circle::name = "circle";

class Rectangle : public Shape
{ public:
	Rectangle(double b, double h) : Shape(name), base(b), height(h) {}
	virtual double getarea() const { return base * height; }
	virtual bool regular() const { return base == height; }   //is it a square?
 private:  
	double base, height;
	static const string name;
};

const string Rectangle::name = "rectangle";

class Triangle : public Shape
{ public:
	Triangle(double b, double h, double a) : Shape(name), base(b), height(h), angle(a) {}
	virtual double getarea() const { return (base * height) / 2; }
	virtual bool regular() const;    //equilateral
 private:
	double base, height, angle;
	static const string name;
};

const string Triangle::name = "triangle";

bool Triangle::regular() const   // is it equilateral?
{	bool nearlyequals(double, double);
	double square(double);
	return nearlyequals(angle,60) and nearlyequals(square(base), square(base/2) + square(height));   // Pythagoras
}

bool nearlyequals(double x, double y)       // non-member function
{	return x >= y - .0001 and x <= y + .0001;
}

double square(double x)
{	return x * x;
}

int main( )
{	vector<Shape*>	v;
	v.push_back(new Circle(2.5));
	v.push_back(new Rectangle(4.0, 2.2));
	v.push_back(new Rectangle(5.0, 5.0));
	v.push_back(new Triangle(3.5, 2.6, 60));
	v.push_back(new Triangle(10, 8.66025, 60));
	cout << fixed << setprecision(2);
	for (int i = 0; i < v.size(); i++)
		cout << "This is a " << v[i]->getname() << " and its area is " << v[i]->getarea() << " and it is " << (v[i]->regular() ? "" : "not ") << "regular."<< endl;
}
