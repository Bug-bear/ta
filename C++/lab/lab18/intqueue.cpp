/* A queue class of ints implemented as a doubly-linked list. */

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

class Dnode
{  public:
	Dnode(int);
	int	n;
	Dnode*	l, *r;
};

Dnode::Dnode(int tx)
{	n = tx;
	l = r = NULL;
}

class Queue
{ public:
	Queue();
	void enqueue(int x);
	int dequeue(void);
	bool empty(void) const;
	void display(void) const;  
private:
	Dnode*	front, *back;
	
};

Queue::Queue()
{	front = back = NULL;
}


void Queue::enqueue(int x)
{	Dnode*	d = new Dnode(x);
	if (empty())
		front = back = d;
	else
	{	back->r = d;
		d->l = back;
		back = d;
	}
}

int Queue::dequeue(void)
{	assert(! empty());
	Dnode*	temp = front;
	front = front->r;
	if (front == NULL)
		back = NULL;
	else	front->l = NULL;
	int	x = temp->n;
	delete temp;
	return x;
}


bool Queue::empty(void) const
{	return front == NULL;
}

void Queue::display(void) const
{	for (Dnode* d = front; d != NULL; d = d->r)
		cout << d->n << " ";
	cout << endl;
}



int main(void)
{	Queue	q;
	if (q.empty())
		cout << "q empty" << endl;
	for (int i = 0; i < 10; i++)
		q.enqueue(i);
	q.display();
	int	x = q.dequeue();
	cout << "x is " << x << endl;
	q.display();

}
