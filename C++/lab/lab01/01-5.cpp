#include <iostream>
using namespace std;

class Info{
	public:
		string fname, mname, lname, address, city, postcode;
		void Input();
		void Display();
};

void Info::Input(){
	cout<<"just type"<<endl;
	getline(cin, fname);
	getline(cin, mname);
	getline(cin, lname);
	getline(cin, address);
	getline(cin, city);
	getline(cin, postcode);
	//cout<<"what have we got is "<<s<<endl;
}

void Info::Display(){
	cout<<fname<<" "<<mname<<". "<<lname<<endl;
	cout<<address<<endl;
	cout<<city<<", "<<postcode;
}

int main(){
	Info Mary;
	Mary.Input();
	Mary.Display();
}