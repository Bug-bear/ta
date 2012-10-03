#include "ccc_time.cpp"
#include <iostream>
using namespace std;

int main(){
	int d_h,d_m,a_h,a_m,s = 0;
	int left,duration,hr,mins;

	Time NOW;
	cout<<"Plz enter the time of departure (hours minutes)"<<endl;
	cin>>d_h>>d_m;
	Time DEP(d_h,d_m,s);
	cout<<"Plz enter the time of arrival (hours minutes)"<<endl;
	cin>>a_h>>a_m;
	Time ARR(a_h,a_m,s);

	left = DEP.seconds_from(NOW);
	hr = left/3600;
	left = left%3600;
	mins = left/60;
	cout<<"Your train departs in "<<hr<<" hours and "<<mins<<" minutes time."<<endl;

	cout<<"Departure time "<<d_h<<":"<<d_m<<endl;
	cout<<"Arrival time "<<a_h<<":"<<a_m<<endl;
	duration = ARR.seconds_from(DEP);
	hr = duration/3600;
	duration = duration%3600;
	mins = duration/60;
	cout<<"Journey time "<<hr<<" hours "<<mins<<" minutes"<<endl;

}