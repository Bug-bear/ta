#include <iostream>
using namespace std;

void rev(int n)
{
	cout<<n%10;
	if (n/10 > 0){
		rev(n/10);
	}
}

int main()
{
	int n;
	cout<<"give me number"<<endl;
	cin>>n;
	rev(n);
}