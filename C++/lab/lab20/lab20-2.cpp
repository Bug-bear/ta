#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>

using namespace std;

class Out_of_bounds{
	public:
		Out_of_bounds(int n):bvalue(n){}
		int badval() const{return bvalue;}
	private:
		int bvalue;
};

class Pop_on_empty{};

class Bivec
{ public:
	Bivec() {low = 0;}
	Bivec(int lo, int hi, int initial_value);
	void push_back(int);
	void push_front(int);
	int pop_back() throw (Pop_on_empty);
	int pop_front() throw (Pop_on_empty);
	int& operator[](int) throw (Out_of_bounds);
	void display() const;
	bool empty() const {return v.size() == 0; }

	Bivec(const Bivec& bx) { copy(bx); }
	~Bivec() { free(); }
	const Bivec& operator=(const Bivec&);
  private:
	vector<int*> v;
	int low;
	void copy(const Bivec&);
	void free();
};

Bivec::Bivec(int lo, int hi, int initial_value){
	low=lo;
	for(int i=0; i<hi-lo; i++)
		v.push_back(new int(initial_value));
}

void Bivec::display() const{
	for(int i=0; i<static_cast<int>(v.size()); i++)
		cout<<*v[i]<<" ";
	cout<<endl;
}

void Bivec::push_back(int n){
	v.push_back(new int(n));
}

void Bivec::push_front(int n){
	v.push_back(NULL);
	for(int i=v.size()-1; i>0; i--){
		v[i]=v[i-1];
	}
	v[0]=new int(n);
}

int Bivec::pop_back() throw (Pop_on_empty){
	if(v.empty()) throw Pop_on_empty();
	int popped=*v[v.size()-1];
	v.pop_back();
	return popped;
}

int Bivec::pop_front() throw (Pop_on_empty){
	if(v.empty()) throw Pop_on_empty();
	int popped=*v[0];
	for(int i=0; i<static_cast<int>(v.size())-1; i++)
		v[i]=v[i+1];
	v.pop_back();
	return popped;
}

int& Bivec::operator[](int index) throw (Out_of_bounds){
	if(index<low||index>low+static_cast<int>(v.size())-1)
		throw Out_of_bounds(index);
	return *v[index-low];
}

void Bivec::copy(const Bivec& b){
	v=b.v;
	low=b.low;
	for(int i=0; i<static_cast<int>(v.size()); i++)
		v[i]=new int(*b.v[i]);
}

void Bivec::free(){
	for(int i=0; i<static_cast<int>(v.size()); i++) delete v[i];
}

const Bivec& Bivec::operator=(const Bivec& b){
	if(this!=&b){
		free();
		copy(b);
	}
	return *this;
}

int main( )
{try{	Bivec b1;
	cout << "b1, initially empty: ";
	b1.display();
	for (int i = 0; i < 10; i++)
		b1.push_back(i);
	cout << "b1, after push_backs: ";
	b1.display();
	b1.push_front(66);
	b1.push_front(77);
	cout << "b1, after push_fronts: ";
	b1.display();
	int last = b1.pop_back(), first = b1.pop_front();
	cout << "last was " << last << ", first was " <<  first << endl;
	cout << "b1, after pops: ";
	b1.display();
	cout << "b1[-1] " << b1[-1] << ", b1[0] " << b1[0] << ", b1[8] " << b1[8] << endl;
	b1[-1] = 88;
	cout << "b1, after b1[-1] = 88: ";
	b1.display();

	Bivec b2(-5, +5, 0);
	cout << "b2, as constructed: ";
	b2.display();

	Bivec b3(b1);
	cout << "b3, copy-constructed from b1: ";
	b3.display();
	b3 = b2;
	cout << "b3, after b3 = b2: ";
	b3.display();
	cout << "Program should now terminate with exception" << endl;
//	cout << b1[50];	// should throw exception
	while( true )
		b3.pop_back();	// should throw exception

}
catch(const Out_of_bounds& ob)
{	cerr << "Invalid subscript " << ob.badval() << endl;
	exit(1);
}
catch(Pop_on_empty)
{	cerr << "Popping empty Bivec" << endl;
	exit(1);
}
} // matches { before try, needed for Borland
