#include <iostream>
#include <assert>

using namespace std;

class Node
{
public:
      string name;
      Node* link;
};

void insert(Node*& list, string s){
	Node* p = new Node;
	p->name=s;
	p->link=NULL;

	if(list==NULL){
		list=p;
	}
	else if(s<list->name){
		p->link=list;
		list=p;
	}
	else{
		Node* next = list->link;
		Node* current = list;
		while(next!=NULL && s>next->name){
			current=next;
			next=next->link;
		}
		p->link=next;
		current->link=p;
	}
}

void remove(Node*& list, string nm){
	Node* cur = list;
	Node* prev = NULL;

	while (cur != NULL && cur->name != nm)
	{ prev =cur;
		cur = cur->link;
	}
	if (cur == NULL)
		cout << "Name not in list\n";
	else if (prev == NULL) // must need to delete first node
	{	list = cur->link;
		delete cur;
	}
	else
	{	prev->link = cur->link;
		delete cur;
	}
}

void display(Node* list)
{	cout << endl;
	if (list == NULL)
		cout << "Empty list";
	while (list != NULL)
	{	cout << list->name << endl;
		list = list->link;
	}
	cout << endl;
}

int main(){
	Node* list = NULL;
	string str;
	cout << "Enter names to insert in list\n";
	while(cin>>str){
		insert(list, str);
	}
	display(list);


}