#include <iostream>
#include <assert>
#include <vector>
#include <iomanip>
#include <fstream>

using namespace std;

class Binode
{ public:
	string	str;
	Binode* l, *r;
	Binode(string x) { str = x; l = r = NULL; }
};

void addnode(Binode*& root, string s){
	Binode*	newnode = new Binode(s);
	if (root == NULL){
		root = newnode;
		return;
	}

	Binode* a = root, *b;
	while (a != NULL){
		b = a;
		if (s < a->str)
			a = a->l;
		else	a = a->r;
	}

	if (s < b->str)
		b->l = newnode;
	else	b->r = newnode;
}

bool there(Binode* root, string s){
	while(root!=NULL){
		if(root->str==s){
			return true;
		}
		if(root->str>s)
			root=root->l;
		else root=root->r;
	}
	return false;
}

int main(){
	string line;
	string what;
	Binode* root=NULL;

	ifstream infile;
   	infile.open("queries.txt");
   	if (infile.fail())
   	{  cout << "Error: input file not opened" << endl;
      	return 1;		// exit program
   	}

	while(getline(infile,line)){
		addnode(root,line);
	}
	cout<<"search for?"<<endl;
	getline(cin,what);
	cout<<there(root,what)<<endl;
}