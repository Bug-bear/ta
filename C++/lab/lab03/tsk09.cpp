#include <iostream>
using namespace std;

int main(){
	string s;
	cout<<"type your string"<<endl;
	cin>>s;
	for(int i=0;i<s.length();i++){
		cout<<s.substr(i,s.length()-i)<<endl;
	}
}