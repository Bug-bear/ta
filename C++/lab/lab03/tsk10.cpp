#include <iostream>
#include <sstream>
using namespace std;

int main(){
	string s;
	int day;
	string month;

	cout<<"Enter date"<<endl;
	getline(cin,s);
	istringstream line(s);
	line>>day>>month;

	switch(day){
		case 1: cout<<day<<"st "<<month<<endl; break;
		case 2: cout<<day<<"nd "<<month<<endl; break;
		case 3: cout<<day<<"rd "<<month<<endl; break;
		case 21: cout<<day<<"st "<<month<<endl; break;
		case 22: cout<<day<<"nd "<<month<<endl; break;
		case 31: cout<<day<<"st "<<month<<endl; break;
		default: cout<<day<<"th "<<month<<endl; break;
	}
}