#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

int alternating_sum(vector<int>& v){
	int sum=0;
	for(int i=0; i<static_cast<int>(v.size()); i++){
		if(!(i%2)) sum+=v[i];
		else sum-=v[i];
	}
	return sum;
}

void reverse(vector<int>& v){
	vector<int> r;
	for(int i=v.size()-1; i>=0; i--){
		r.push_back(v[i]);
	}
	v=r;
}

vector<int> append(vector<int>& v1, vector<int>& v2){
	vector<int> joint;
	for(int i=0; i<static_cast<int>(v1.size()); i++){
		joint.push_back(v1[i]);
	}
	for(int i=0; i<static_cast<int>(v2.size()); i++){
		joint.push_back(v2[i]);
	}
	return joint;
}

int main(){
	vector<int> vec;
	vector<int> vec1(3,0);
	vector<int> vec2(5,1);
	int num=0;
	ifstream infile;

	infile.open ("input.txt");
	assert(!infile.fail());

	while(infile>>num){
		vec.push_back(num);
		infile.ignore();
	}

	//cout<<alternating_sum(vec)<<endl;
	/*
	reverse(vec);
	for(int i=0; i<static_cast<int>(vec.size()); i++){
		cout<<vec[i]<<" ";
	}
	*/
	vector<int> ret = append(vec1,vec2);
	for(int i=0; i<static_cast<int>(ret.size()); i++){
		cout<<ret[i]<<" ";
	}
}