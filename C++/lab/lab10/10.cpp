#include <iostream>
#include <assert>

using namespace std;

class Node
{
public:
   int n;
   Node* link;
};

void display(Node* p){
	while(p!=NULL){
		cout<<p->n<<" ";
		p=p->link;
	}
	cout<<endl;
}

void addnode(Node*& h, int val){
	Node* y = new Node;
	y->n = val;
	y->link=NULL;
	if(h==NULL){
		h=y;
		return;
	}
	y->link=h;
	h=y;
}

bool inThere(Node* h, int val){
	while(h!=NULL){
		if(h->n==val) return true;
		h=h->link;
	}
	return false;
}

void addtail(Node*& h, int val){
	Node* y = new Node;
	y->n = val;
	y->link=NULL;
	if(h==NULL){
		h=y;
		return;
	}
	Node* z = h;
	while(z->link!=NULL){
		z=z->link;
	}
	z->link=y;
}

int removeHead(Node*& h){
	assert (h!=NULL);
	int x = h->n;
	h=h->link;
	return x;
}

int removeTail(Node*& h){
	assert (h!=NULL);
	Node* x = h, *y;
	while(x->link!=NULL){
		y=x;
		x=x->link;
	}
	int z = x->n;
	delete x;
	y->link=NULL;
	return z;
}

int main(){
	int num;
	Node* head = new Node;
	head=NULL;
	Node* head2 = new Node;
	head2=NULL;
	for(int i=0; i<6; i++){
		addnode(head,i);
	}
	display(head);
/*
	cout<<"search for?"<<endl;
	cin>>num;
	cout<<inThere(head,num)<<endl;
*/

	for(int i=0; i<6; i++){
		addtail(head2,i);
	}
	display(head2);

	//cout<<removeHead(head2)<<endl;
	cout<<removeTail(head2)<<endl;
	display(head2);
}