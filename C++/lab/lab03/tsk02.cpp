#include <iostream>
using namespace std;

int main(){
	int n;

	cout<<"Plz input a number between 1000 and 3000"<<endl;
	cin>>n;

	if(n>1000&&n<3000){
		cout<<"OK"<<endl;
	}

	else
		cout<<"Not OK"<<endl;
}