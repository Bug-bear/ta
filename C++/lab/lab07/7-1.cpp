#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

double scalar_product(vector<double>& v1, vector<double>& v2){
	double pro;
	for(int i=0; i<static_cast<int>(v1.size()); i++){
		pro+=v1[i]*v2[i];
	}
	return pro;
}

int main(){
	vector<double> vec1, vec2;
	double num;
	int ctr=0;
	ifstream infile;

	infile.open ("doubles");
	assert(!infile.fail());

	while(infile>>num){
		ctr++;
		if(ctr%2) vec1.push_back(num);
		else vec2.push_back(num);
	}

	cout<<scalar_product(vec1,vec2)<<endl;
}