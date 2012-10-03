#include <iostream>

using namespace std;

class Node
{
public:
	int n;
	Node *link;
};

void addnode(Node*&, int);
void display(Node*);
bool sorted(Node*);

int main()
{
	cout << "Enter ints to store in linked list\n";
	int n;
	Node* list = NULL;
	while (cin >> n)
	{	cin.ignore();
		addnode(list,n);
	}
	display(list);
	cout << endl;
	cout <<  (sorted(list) ? "Ascending" : "Not ascending" ) << endl;
}



void addnode(Node*& head, int n)
{
	if (head == NULL)
	{ 	head = new Node;
		head->n = n;
		head->link = NULL;
	}
	else
		addnode(head->link, n);
}

void display(Node* head)
{
	if (head != NULL)
	{	cout << head->n << " " ;
		display(head->link);
	}
}

bool sorted(Node* head)
{
	if(head == NULL || head->link == NULL)
		return true;
	if (head->n <= head->link->n)
		return sorted(head->link);
	else return false;
}