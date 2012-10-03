#include <iostream>

using namespace std;

#include "ccc_time.cpp"

void addTime(Time& t, int h){
	t.add_seconds(h*3600);
}

int main(){
	int h;
	cout<<"number of hours"<<endl;
	cin>>h;
	Time now;
	addTime(now,h);
	cout<<now.get_hours()<<":"<<now.get_minutes()<<":"<<now.get_seconds()<<endl;
}