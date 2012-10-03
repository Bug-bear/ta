#include <iostream>
using namespace std;

bool ifleap(const int& y){
	if(y%400==0)
		return true;
	else if(y%100==0)
		return false;
	else if(y%4==0)
		return true;
	else return false;
}

int main(){
	int year;
	while(!cin.eof()){
		cout<<"enter a year"<<endl;
		cin>>year;
		cin.ignore();
		if(cin.fail()) break;
		else {
			if(ifleap(year))
				cout<<"leap year"<<endl;
			else cout<<"not leap year"<<endl;
		}
	}
}

