#include <iostream>

using namespace std;

void swap(string& s1, string& s2){
	string temp;
	if(s1.length()<s2.length()){
		temp = s1;
		s1=s2;
		s2=temp;
	}
}

int main(){
	string a,b;
	cout<<"type 2 strings"<<endl;
	cin>>a>>b;
	swap(a,b);
	cout<<a<<"\t"<<b<<endl;
}