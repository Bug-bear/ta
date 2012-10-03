#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

int main(){
	string str;
	char del;
	ifstream infile;

	infile.open ("input6.txt");
	assert(!infile.fail());

	getline(infile,str);
	cout<<"get rid of ?"<<endl;
	cin>>del;

	for(int i=0; i<static_cast<int>(str.size()); i++){
		if(str[i]==del) str[i]='*';
	}
	cout<<str<<endl;
}