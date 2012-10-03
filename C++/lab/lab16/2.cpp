#include <iostream>
using namespace std;

void out(int n)
{	if (n > 0)
	{	out(n - 1);
		cout << n;
		out(n - 1);
	}
}

int main()
{	for (int i = 1; i <= 5; i++)
	{	out(i);
		cout << endl;
	}
}