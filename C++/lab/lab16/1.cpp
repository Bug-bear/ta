#include <iostream>
using namespace std;

void tri(string s){
	if(s.size()>0){
		cout<<s<<endl;
		tri(s.substr(0,s.size()-1));
	}
}

int main (){
	string sx;
	cout<<"input string: "<<endl;
	cin>>sx;
	tri(sx);
}