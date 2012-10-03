#include "ccc_time.cpp"
#include <iostream>
using namespace std;

int main(){
	int d_h,d_m,a_h,a_m,s = 0;
	int left,duration,hr,mins;

	Time NOW;
	cout<<"Plz enter the time you arrived at BBK (hours minutes)"<<endl;
	cin>>a_h>>a_m;
	Time ARR(a_h,a_m,s);

	cout<<"Plz enter the time you will go home (hours minutes)"<<endl;
	cin>>d_h>>d_m;
	Time DEP(d_h,d_m,s);

	duration = NOW.seconds_from(ARR);
	hr = duration/3600;
	duration = duration%3600;
	mins = duration/60;
	cout<<"You have been here for "<<hr<<" hours and "<<mins<<" minutes time."<<endl;

	left = DEP.seconds_from(NOW);
	hr = left/3600;
	left = left%3600;
	mins = left/60;
	cout<<"You will be going home in "<<hr<<" hours and "<<mins<<" minutes time."<<endl;
}