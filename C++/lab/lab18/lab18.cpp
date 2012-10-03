/* A queue class of ints implemented as a doubly-linked list. */

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

class Dnode{
	public:
		Dnode(int);
		int	n;
		Dnode*	l, *r;
};

Dnode::Dnode(int tx){
	n = tx;
	l = r = NULL;
}

class Queue{
	public:
		Queue();
		void enqueue(int x);
		int dequeue(void);
		bool empty(void) const;
		void display(void) const;
		Queue(const Queue&);
		~Queue();
		Queue& operator=(const Queue&);
		void displayrev() const;
		void remove(int);
	private:
		Dnode*	front, *back;
		void copy(Dnode*);
		void free();
};

Queue::Queue(){
	front = back = NULL;
}

Queue::Queue(const Queue& old){
	assert(! old.empty());
	copy(old.front);
}

Queue::~Queue(){
	free();
	cout<<"destructor called"<<endl;
}

Queue& Queue::operator=(const Queue& nq){
	if(this != &nq){
		free();
		copy(nq.front);
	}
	return *this;
}

void Queue::free(){
	while(!empty()){
		dequeue();
	}
}

void Queue::copy(Dnode* f){
	front = back = NULL;
	for(Dnode* q=f; q!=NULL; q=q->r)
		enqueue(q->n);
}

void Queue::displayrev(void) const
{	for (Dnode* d = back; d != NULL; d = d->l)
		cout << d->n << " ";
	cout << endl;
}

void Queue::remove(int x){
	Dnode* d;
	for(d = front; d->n!=x||d!=NULL; d=d->r);
	if(d==NULL)		return;
	if(d==front)	dequeue();
	if(d==back)		back=d->l;
	else{
		d->l->r=d->r;
		d->r->l=d->l;
	}
	delete d;
	d=NULL;
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

	Queue q1(q);
	q1.display();

	Queue q2=q1;
	q2.display();

	q1=q1;
	q1.display();

	q1.displayrev();
}
