#include <iostream>
#include <vector>

using namespace std;

bool test(vector<int>& v, int top, int n){
	if(top==-1) return true;
	else return (v[top]<n) && test(v, top-1, n);
}

int main (){
	vector<int> vec;
	int i;
	int j;
	cout<<"feed the vec"<<endl;
	while(cin>>i)
		vec.push_back(i);
	cin.clear();
	cout<<"num to test"<<endl;
	cin>>j;
	cout<<test(vec,vec.size()-1,j)<<endl;
}