#include <iostream>

using namespace std;

#include "ccc_time.cpp"

Time duration(Time& s, Time& f){
	int sec;
	int h;
	int m;
	Time mid1(23,59,59);
	Time mid2(0,0,0);
	if(f.get_hours()<s.get_hours())
		sec = mid1.seconds_from(s)+f.seconds_from(mid2);
	else
		sec = f.seconds_from(s);
	h = sec/3600;
	sec=sec%3600;
	m = sec/60;
	Time dur(h, m, 0);
	return dur;
}

int main(){
	int h,m;
	cout<<"enter start time (hour:min)"<<endl;
	cin>>h;
	cin.ignore();
	cin>>m;
	Time start(h,m,0);
	cout<<"enter finish time (hour:min)"<<endl;
	cin>>h;
	cin.ignore();
	cin>>m;
	Time finish(h,m,0);

	cout<<duration(start,finish).get_hours()<<":"
		<<duration(start,finish).get_minutes()<<endl;
}