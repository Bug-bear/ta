#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

class Rect
{
	public:
		Rect(){height=1; width=1;};
		Rect(double, double);
		double getheight() const;
		double getwidth() const;
		void setheight(const double);
		void setwidth(const double);
		bool enclose(const Rect&) const;
		void calculate() const;
		bool samesize(const Rect&) const;
		bool operator==(const Rect&) const;
	private:
		double height;
		double width;
};

Rect::Rect(double h, double w){
	height=h;
	width=w;
}

double Rect::getheight() const{
	return height;
}

double Rect::getwidth() const{
	return width;
}

void Rect::setheight(const double h){
	height = h;
}

void Rect::setwidth(const double w){
	width = w;
}

bool Rect::enclose(const Rect& r) const{
	return (this->height)*(this->width)>(r.height)*(r.width);
}

void Rect::calculate() const{
	cout<<"area is "<<height*width<<" and perimeter is "<<2*(height+width)<<endl;
}

bool Rect::samesize(const Rect& r) const{
	return (this->height==r.height)&&(this->width==r.width)
		||(this->width==r.height)&&(this->height==r.width) ;
}

bool Rect::operator==(const Rect& r) const{
	return (this->height==r.height)&&(this->width==r.width)
		||(this->width==r.height)&&(this->height==r.width) ;
}

int main( )
{  Rect a; // Default is 1 by 1.
   Rect b;
   cout << "Rectangle a is " << a.getwidth() << " by "
   << a.getheight() << "." << endl;
   cout << "Rectangle b is " << b.getwidth() << " by "
   << b.getheight() <<  "."  << endl;
   cout << (a.enclose(b) ? "a encloses b." : "a does not enclose b") << endl;
   a.setwidth(2.2);
   a.setheight(3.5);
   cout << "Rectangle a is " << a.getwidth() << " by "
   << a.getheight() << "." << endl;
   cout << (a.enclose(b) ? "a encloses b." : "a does not enclose b") << endl;

   Rect c(3,6);
   cout << "Rectangle c is " << c.getwidth() << " by "
   << c.getheight() << "." << endl;
   c.calculate();
}