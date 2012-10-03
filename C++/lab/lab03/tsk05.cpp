#include <iostream>
#include <iomanip>
using namespace std;

int main(){
	cout<<setw(10)<<"Integer"<<setw(10)<<"Square"<<setw(10)<<"Cube"<<endl;
	for (int i=1;i<11;i++){
		cout<<setw(10)<<i<<setw(10)<<pow(i,2)<<setw(10)<<pow(i,3)<<endl;
	}
}