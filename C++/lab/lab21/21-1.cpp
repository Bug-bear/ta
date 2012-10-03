#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>

using namespace std;
#include "bivec.h"

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
	cout << "Program should now terminate with exception" << endl;
//	cout << b1[50];	// should throw exception
//	while( true )
//		b3.pop_back();	// should throw exception

	Bivec<string> b4;
	b4.push_back("I am ");
	b4.push_back("bug");
	b4.push_back("bear");
	b4.display();

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
