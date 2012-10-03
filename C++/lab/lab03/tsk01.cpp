#include <iostream>
using namespace std;

int main(){
	int n;
	string s;

	cout<<"Plz input your string"<<endl;
	cin>>s;
	cout<<"input n"<<endl;
	cin>>n;

	if(s.length()>n||s.length()==n){
		cout<<s.substr(0,n)<<endl;
	}

	else
		cout<<"String too short"<<endl;
}