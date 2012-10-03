#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>

using namespace std;

class FileNotFoundException{
	public:
		FileNotFoundException(string s):name(s){};
		string getname(){return name;};
	private:
		string name;
};

class BadDataException{
	public:
		BadDataException(string s):badline(s){};
		string reportline(){return badline;};
	private:
		string badline;
};

class Myvec{
	public:
		Myvec(string) throw (FileNotFoundException,BadDataException);
	private:
		vector<int> v;
};

Myvec::Myvec(string filename) throw (FileNotFoundException,BadDataException){
	ifstream infile;
	infile.open(filename.c_str());
	if(infile.fail()) throw FileNotFoundException(filename);
	string s;
	while(getline(infile,s)){
		istringstream is(s);
		int data;
		is>>data;
		if(is.fail()) throw BadDataException(s);
		v.push_back(data);
	}
}

int main(){
	try{
		Myvec vec = Myvec("data.txt");
	}
	catch(FileNotFoundException e){
		cout<<e.getname()<<" not found"<<endl;
		exit(1);
	}
	catch(BadDataException e){
		cout<<"Bad data: "<<e.reportline()<<endl;
		exit(1);
	}
}