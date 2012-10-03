#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

void display(vector<string> v){
	for(int i=0; i<static_cast<int>(v.size()); i++){
			cout<<i+1<<" "<<v[i]<<endl;
		}
}

void remove(vector<string>& v, int line){
	vector<string> ret;
	for(int i=0; i<static_cast<int>(v.size()); i++){
			if(i!=(line-1))
				ret.push_back(v[i]);
		}
	v=ret;
}

int main(){
	string str;
	int rm;
	vector<string> vec;

	cout<<"give me 5 lines"<<endl;
	for(int i=0; i<5; i++){
		getline(cin,str);
		vec.push_back(str);
	}

	cout<<"which one to remove?"<<endl;
	cin>>rm;
	remove(vec,rm);
	display(vec);
}