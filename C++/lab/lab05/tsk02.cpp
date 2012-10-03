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

void sort(string& i, string& j, string& k){
	swap(i,j);
	swap(i,k);
	swap(j,k);
}

int main(){
	string a,b,c;
	cout<<"type 3 strings"<<endl;
	cin>>a>>b>>c;
	sort(a,b,c);
	cout<<a<<"\t"<<b<<"\t"<<c<<endl;
}