#include <iostream>
#include <assert>
#include <vector>
#include <iomanip>
#include <fstream>

using namespace std;

void display(const int arr[], int len){
	for(int i=0; i<len; i++)
		cout<<arr[i]<<" ";
	cout<<sizeof(arr)<<endl;
}

void add(vector<int> v, int arr[]){
	for(int i=0; i<static_cast<int>(v.size()); i++){
		arr[i]=arr[i]+v[i];
	}
}

int main(){
	int a[12] = {1,1,1,1,1,1};
	cout<<sizeof(a)<<endl;

	display(a,12);

	vector<int > vec(12);
	for(int i=0; i<static_cast<int>(vec.size()); i++){
		vec[i]=a[i];
	}

	add(vec,a);
	display(a,12);
}