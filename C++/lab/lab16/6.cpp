#include <iostream>
#include <string>
#include <sstream>
#include <cctype>
using namespace std;


bool empty(istringstream& is)
{	char	ch;
	is.get(ch);
	return is.fail();
}

bool isvalid(istringstream& is)
{	char ch;
	is.get(ch); cout << ch;
	if (ch != '(')
		return isdigit(ch);
	bool b1 = isvalid(is);
	is.get(ch); cout << ch;
	if (ch != '+')
		return false;
	bool b2 = isvalid(is);
	is.get(ch); cout << ch;
	if (ch != ')')
		return false;
	return b1 && b2;
}

int main()
{	string s;
	while(getline(cin, s))
	{	istringstream	is(s);
		cout << (isvalid(is) && empty(is) ?
			"Expression OK" : "Not OK") << endl;
	}
}