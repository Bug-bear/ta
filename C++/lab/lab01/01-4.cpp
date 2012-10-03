#include <iostream>
#include <iomanip>
using namespace std;

int main(){
	int p, pound;
	double pence;
	cout<<"just type"<<endl;
	do{
		cin>>p;

		pound = p/100;
		p = p%100;
		pence = (double)p/100;

		cout<<"The amount is "<<fixed << setprecision(2)<<pound+pence<<endl;
	}
	while(cin.get()==',');
}