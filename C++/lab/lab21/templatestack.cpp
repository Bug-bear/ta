/* A stack template class, implemented as a singly-linked list.
   All occurrences of "Stack" could be "Stack<T>".
*/

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;
template<typename T>
class Stack
{ public:
	Stack();
	void push(T x);
	T pop( );
	void display( ) const;
	bool empty( ) const;
	Stack(const Stack&);
	~Stack();
	Stack& operator=(const Stack&);
  private:
	class Node;
	Node* top;
	void copy(Node*&, Node*);
	void free(Node*&);
};

template<typename T>
class Stack<T>::Node
{ public:
	T	n;
	Node*	link;
	Node(T);
};

template<typename T>
Stack<T>::Node::Node(T x)
{	n = x;
	link = NULL;
}

template<typename T>
Stack<T>::Stack()
{	top = NULL;
}

template<typename T>
void Stack<T>::copy(Node*& ts, Node* tx)
{	if (tx == NULL)
		ts = NULL;
	else
	{	ts = new Node(tx->n);
		copy(ts->link, tx->link);
	}
}

template<typename T>
void Stack<T>::free(Node*& ts)
{	if (ts != NULL)
	{	free(ts->link);
		delete ts;
		ts = NULL;
	}
}

template<typename T>
Stack<T>::Stack(const Stack& sx)
{	copy(top, sx.top);
}

template<typename T>
Stack<T>::~Stack()
{	cout << "Destructor called\n";
	free(top);
}

template<typename T>
Stack<T>& Stack<T>::operator=(const Stack& sx)
{	if (this != &sx)
	{	free(top);
		copy(top, sx.top);
	}
	return *this;
}

template<typename T>
void Stack<T>::push(T x)
{	Node*	p = new Node(x);
	p->link = top;
	top = p;
}

template<typename T>
T Stack<T>::pop( )
{	if (empty())
	{	cerr << "Cannot pop empty stack" << endl;
		exit(1);
	}
	Node*	p = top;
        T	x = top->n;
	top = top->link;
	delete p;
	return x;
}

template<typename T>
void Stack<T>::display( ) const
{	for (Node* p = top; p != NULL; p=p->link)
		cout << p->n << " ";
	cout << endl;
}

template<typename T>
bool Stack<T>::empty( ) const
{	return top == NULL;
}

int main( )
{	cout << "Test of stack of ints" << endl;
	Stack<int> st;
	for (int i = 0; i < 5; i++)
		st.push(i);
	st.display();
	int x = st.pop();
	cout << x << endl;
	st.display();

	cout << endl << "Test of stack of strings" << endl;
	Stack<string> sst;
	sst.push("Happy");
	sst.push("Sneezy");
	sst.push("Dopey");
	sst.push("Doc");
	cout << "sst: "; sst.display();
	string dwarf = sst.pop();
	cout << "dwarf is " << dwarf << ", sst: ";
	sst.display();
	cout << endl << "Note how destructors are called at end of program:" << endl;
}
