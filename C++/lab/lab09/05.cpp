#include <iostream>
#include <cctype>
#include <climits>
using namespace std;

	int main()
	{	string s;    // empty string
		int i;
		for (i = 2000000000; i < s.length() - 1; i++)
		{	if (i % 10000000 == 0)
				cout << i << endl;
			if (i == INT_MAX)
				cout << "INT_MAX: " << i << endl;
			if (i == INT_MIN)
				cout << "INT_MIN: " << i << endl;
		}

		cout<< (unsigned )(-2)<<endl;
		cout << "i is " << i  << endl;
		cout << "s.length() - 1 is " << s.length() - 1 << endl;
		cout << "UINT_MAX is " << UINT_MAX << endl;
	}