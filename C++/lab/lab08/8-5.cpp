#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

void display(vector<string>& v){
	for(int i=0; i<static_cast<int>(v.size()); i++){
		cout<<v[i]<<endl;
	}
}

void remove(vector<string>& v, char c){
	vector<string> vn;
	for(int i=0; i<static_cast<int>(v.size()); i++){
		if(v[i][0]==c)	continue;
		vn.push_back(v[i]);
	}
	v=vn;
}

int main(){
	vector<string> vec;
	string line;
	char ch;
	ifstream infile;

	infile.open ("nursery.txt");
	assert(!infile.fail());

	while(getline(infile,line)){
		vec.push_back(line);
	}
	display(vec);

	cout<<"give me a char"<<endl;
	cin>>ch;
	remove(vec, ch);
	display(vec);
}