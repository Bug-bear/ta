#include <iostream>
#include <assert>

using namespace std;

class Binode
{
	public:
		int	n;
		Binode* l, *r;
		Binode(int x) { n = x; l = r = NULL; }
};

void display(Binode* list)
{	cout << endl;
	if (list == NULL){
		cout << "Empty list";
		return;
	}
	if(list->l==NULL){
		while (list != NULL)
		{
			cout << list->n << endl;
			list = list->r;
		}
	}
	else if(list->r==NULL){
		while (list != NULL)
		{
			cout << list->n << endl;
			list = list->l;
		}
	}
	cout << endl;
}

void createSingle(Binode*& head, int s){
	Binode* p = new Binode(s);

	if(head==NULL){
		head=p;
	}
	/*
	else{
		Binode* current = head;
		while(current->r!=NULL){
			current=current->r;
		}
		current->r=p;
	}
	*/
	else{
		p->r=head;
		head=p;
	}
}

Binode* makeDouble(Binode*& head){
	if(head==NULL){
		return NULL;
	}
	else{
		head->l=NULL;
		Binode* current = head;
		Binode* next = current;
		while(current->r!=NULL){
			next=current->r;
			next->l=current;
			current=next;
		}
		return current;
	}
}

void remove(Binode*& left, int s){
	if(left==NULL) return;

	Binode* current=left;
	while (current != NULL){
		if(current->n==s){
			if(current->l==NULL){
				current->r->l=NULL;
			}
			else{
				current->l->r=current->r;
				current->r->l=current->l;
			}
			delete current;
			break;
		}
		else current=current->r;
	}
}

int main(){
	Binode* head = NULL;
	int number;
	cout << "Enter names to insert in list\n";
	while(cin>>number){
		createSingle(head, number);
	}
	cin.clear();
	display(head);
	Binode* right = makeDouble(head);
	display(right);
	cout<<"delete what?"<<endl;
	//cin>>number;
	remove(head,456);
	display(head);
}