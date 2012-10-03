#include <iostream>
#include <fstream>
using namespace std;

class Word
{public:
      string s;
      int n;
      Word *l, *r;
};

void addnode(Word*&, string);

class Wordbag{
	public:
		Wordbag():top(NULL){};
		Wordbag(string);
		int occur(string);
	private:
		Word* top;
		copy(Wordbag*& tnew, Wordbag* texist);
};

Wordbag::Wordbag(string file){
	ifstream infile;
	infile.open(file.c_str());
	if (infile.fail())
   	{
		cout << "Error: input file not opened" << endl;
		return;
   	}
   	string line;
   	while(getline(infile,line))
	{
		addnode(top,line);
	}
}

void addnode(Word*& bn, string s){
	if(bn==NULL)
	{
		bn = new Word;
		bn->s= s;
		bn->n= 1;
		bn->l = bn->r = NULL;
	}
	else if(bn->s > s) addnode(bn->l, s);
	else if(bn->s < s) addnode(bn->r, s);
	else bn->n++;
}

int main(){

}