#include <iostream>
using namespace std;

class Binode
{public:
      string s;
      int n;
      Binode *l, *r;
};

void addnode(Binode*& bn, string s){
	if(bn==NULL)
	{
		bn = new Binode;
		bn->s= s;
		bn->n= 1;
		bn->l = bn->r = NULL;
	}
	else if(bn->s > s) addnode(bn->l, s);
	else if(bn->s < s) addnode(bn->r, s);
	else bn->n++;
}

void display(Binode* bn){
	if(bn!=NULL)
	{
		display(bn->l);
		cout<<bn->s<<" "<<bn->n<<endl;
		display(bn->r);
	}
}

int countnode(Binode* bn){
	if (bn==NULL)
		return 0;
	else
		return 1+countnode(bn->l)+countnode(bn->r);
}

int occurrence(Binode* bn, int nocc){
	if(bn==NULL)
		return 0;
	int n = (bn->n == nocc ? 1 : 0);
	return n + occurrence(bn->l, nocc) + occurrence(bn->r, nocc);
}

int main(){
	Binode* top=NULL;
	string line;
	while(getline(cin,line))
	{
		addnode(top,line);
	}
	display(top);
	cout<<countnode(top)<<endl;
	int n;
	for (int i = 1; i <= 5; i++){
		cout<<occurrence(top,i)<<endl;
	}
}