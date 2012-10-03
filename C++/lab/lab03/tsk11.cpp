#include <iostream>
#include <sstream>
using namespace std;

int main(){
	string s;
	int day;
	string month;

	cout<<"Enter date"<<endl;

	while(getline(cin,s)){

	istringstream line(s);
	line>>day>>month;

		if(line.fail()!=1){
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
		else{
			cout<<"bad input"<<line.good()<<endl;
			continue;
		}

	}
}