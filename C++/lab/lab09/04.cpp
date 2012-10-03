/*
Example of the use of a stack, implemented as an array.
(For consistency with the Data Structures notes, we ignore element[0].)
The program reads expressions of the form (operand operator operand),
such as ((3+2)*(5-3)), and evaluates them.
The expression contains only single digits, no spaces, and is fully bracketed.
Error handling has been omitted, to keep it simple.
Sections of the Stack class are omitted, for students to complete as an exercise.
*/

#include <iostream>
#include <cctype>
#include <cstdlib>
using namespace std;

class Info
{ public:
	char c;
	int	v;
	Info() {c = ' '; v = 0;}
};

class Stack
{ public:
	Stack() { top = 0;}
	void push(Info);
	Info pop();
	void display() const;
  private:
	static const int MAX = 30;
	Info	array[MAX+1];	// we'll ignore array[0]
	int	top;
};

void Stack::push(Info info){
	if (top >= MAX)
		{	cerr << "Stack overflow!" << endl;
			return;
		}
		top++;
	array[top] = info;
}

Info Stack::pop(){
	if (top == 0)
	{	cerr << "Stack underflow!" << endl;
		return Info();
	}
	Info returnval = array[top];
	top--;
	return returnval;
}

void Stack::display() const
{	for (int i = 1; i <= top; i++)
		if (array[i].c == ' ')
			cout << array[i].v;
		else	cout << array[i].c;
	cout << endl;
}

int main()
{	Stack	st;
	char	ch;
	while(cin.get(ch) && ch != '\n')
	{	if (ch != ')')
		{	Info	info;
			if (isdigit(ch))
				info.v = ch - '0';  // convert char to int
			else	info.c = ch;
			st.push(info);
		}
		else
		{	int	v1, v2;
			char	op;
			st.display();
			v2 = st.pop().v;
			op = st.pop().c;
			v1 = st.pop().v;
			st.pop();	// throw away '('
			Info	inx;
			switch (op)
			{ case '+' : inx.v = v1+v2; break;
			  case '-' : inx.v = v1-v2; break;
			  case '*' : inx.v = v1*v2; break;
			  case '/' : inx.v = v1/v2;
			}
			st.push(inx);
		}
	}
	cout << st.pop().v << endl;
}
