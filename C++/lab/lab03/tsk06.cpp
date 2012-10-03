#include <iostream>
using namespace std;

int main(){
	string s;
	cout<<"enter filename(s)"<<endl;

		while(cin.peek()!='\n'){
		cin>>s;
		for(int i=0;i<s.length();i++){
			if(s.at(i)=='.')
				cout<<s.substr(0,i)<<endl;
		}
	}
}