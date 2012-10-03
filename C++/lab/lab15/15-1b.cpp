#include <iostream>
using namespace std;

int plustorial(int n){
	if(n==0) return n;
	else if(n>0) return n+plustorial(n-1);
	else return n+plustorial(n+1);
}

int main (){
	int n=0;
	cout<<"input n: "<<endl;
	cin>>n;
	cout<<plustorial(n);
}