#include <iostream>
using namespace std;

void ifleap(const int& y);

int main(){
	int year;
	while(!cin.eof()){
		cout<<"enter a year"<<endl;
		cin>>year;
		cin.ignore();
		if(cin.fail()) break;
		else ifleap(year);
	}
}

void ifleap(const int& y){
	if(y%400==0)
		cout<<"leap"<<endl;
	else if(y%100==0)
		cout<<"not leap"<<endl;
	else if(y%4==0)
		cout<<"leap"<<endl;
	else cout<<"not leap"<<endl;
}