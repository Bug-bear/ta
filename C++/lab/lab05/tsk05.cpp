#include <iostream>

using namespace std;

bool dup(string s){
	for(int i=0; i<s.length()-1; i++){
		if(s[i]==s[i+1]){
			return true;
		}
	}
	return false;
}

void replace(string& s){
	for(int i=0; i<s.length()-1; i++){
		if(s[i]==s[i+1]){
			s[i+1]='*';
		}
	}
}

int main(){
	string str;
	cout<<"enter strings"<<endl;
	cin>>str;

	if(dup(str)){
		replace(str);
		cout<<"Double letters removed: "<<str<<endl;
	}
	else cout<<"No Double letters: "<<str<<endl;
}