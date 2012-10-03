#include "ccc_time.cpp"
#include <iostream>
using namespace std;

int main(){
	int hr;
	Time tx;
	cout<<"Plz enter the number of hours"<<endl;
	cin>>hr;
	cout<<"The time "<<hr<<" hours from now will be "
		<<(tx.get_hours()+hr)<<":"<<tx.get_minutes()<<":"<<tx.get_seconds();
}