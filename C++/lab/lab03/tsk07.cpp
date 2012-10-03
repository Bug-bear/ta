#include <iostream>
using namespace std;

int main(){
	int sum=0;
	int count=0;
	int max=0;
	int min=0;
	int i=0;

	cout<<"reading data from file"<<endl;
	while(cin>>i){
		sum += i;
		max=(max<i?i:max);
		min=(min>i?i:min);
		count++;
	}

	cout<<"number of integers: "<<count<<endl;
	cout<<"sum: "<<sum<<endl;
	cout<<"average: "<<(double)sum/count<<endl;
	cout<<"max: "<<max<<endl;
	cout<<"min: "<<min<<endl;
}