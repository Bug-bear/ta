#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>

using namespace std;
#include "bivec.h"
#include "date.h"

template<typename T>
Bivec<T>::Bivec(int lo, int hi, T initial_value){
	low=lo;
	for(int i=0; i<hi-lo; i++)
		v.push_back(new T(initial_value));
}

template<typename T>
void Bivec<T>::display() const{
	for(int i=0; i<static_cast<int>(v.size()); i++)
		cout<<*v[i]<<" ";
	cout<<endl;
}

template<typename T>
void Bivec<T>::push_back(T n){
	v.push_back(new T(n));
}

template<typename T>
void Bivec<T>::push_front(T n){
	v.push_back(NULL);
	for(int i=v.size()-1; i>=0; i--){
		v[i]=v[i-1];
	}
	v[0]=new T(n);
}

template<typename T>
T Bivec<T>::pop_back() throw (Pop_on_empty){
	if(v.empty()) throw Pop_on_empty();
	T popped=*v[v.size()-1];
	v.pop_back();
	return popped;
}

template<typename T>
T Bivec<T>::pop_front() throw (Pop_on_empty){
	if(v.empty()) throw Pop_on_empty();
	T popped=*v[0];
	for(int i=0; i<static_cast<int>(v.size())-1; i++)
		v[i]=v[i+1];
	v.pop_back();
	return popped;
}

template<typename T>
T& Bivec<T>::operator[](int index) throw (Out_of_bounds){
	if(index<low||index>low+static_cast<int>(v.size())-1)
		throw Out_of_bounds(index);
	return *v[index-low];
}

template<typename T>
void Bivec<T>::copy(const Bivec& b){
	v=b.v;
	low=b.low;
	for(int i=0; i<static_cast<int>(v.size()); i++)
		v[i]=new T(*b.v[i]);
}

template<typename T>
void Bivec<T>::free(){
	for(int i=0; i<static_cast<int>(v.size()); i++)
		delete v[i];
}

template<typename T>
const Bivec<T>& Bivec<T>::operator=(const Bivec& b){
	if(this!=&b){
		free();
		copy(b);
	}
	return *this;
}

int main( )
{try{	Bivec<int> b1;
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
	//cout << "b1[-1] " << b1[-1] << ", b1[0] " << b1[0] << ", b1[8] " << b1[8] << endl;
	//b1[-1] = 88;
	cout << "b1, after b1[-1] = 88: ";
	b1.display();

	Bivec<int> b2(-5, +5, 0);
	cout << "b2, as constructed: ";
	b2.display();

	Bivec<int> b3(b1);
	cout << "b3, copy-constructed from b1: ";
	b3.display();
	b3 = b2;
	cout << "b3, after b3 = b2: ";
	b3.display();
	//cout << "Program should now terminate with exception" << endl;
	//cout << b1[50];	// should throw exception
	//while( true )
	//	b3.pop_back();	// should throw exception

	Bivec<string> b4;
	b4.push_back("I am ");
	b4.push_back("bug");
	b4.push_back("bear");
	b4.display();

	Bivec<Date> dates(-1,5,Date());
	dates.display();

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
