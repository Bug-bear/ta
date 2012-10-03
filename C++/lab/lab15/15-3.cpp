
#include <iostream>
#include <string>
#include <vector>
using namespace std;

#include "dateclass.cpp"

class Entry
{ public:
	Date date;
	string text;
};

class Diary
{ private:
	vector<Entry> v;
	void insert(const Entry& e);
  public:
	void add_entry();
	void show_week() const;
};


void Diary::add_entry()
{	Entry e;
	cin >> e.date;	// overloaded >> has its own prompts
	cout << "And some text?";
	getline(cin, e.text);
	insert(e);
}

void Diary::insert(const Entry& e)
{	int i;
	for (i = 0; i < v.size() && e.date > v[i].date; i++)
		;
	v.push_back(e);
	for (int j = v.size() - 1; j > i; j--)	// just done push_back, so size certainly > 0
		v[j] = v[j-1];
	v[i] = e;
}

void Diary::show_week() const
{	Date	d1;
	cin >> d1;
	Date	d2(d1);
	d2 += 7;
	bool empty = true;
	for (int i = 0; i < v.size(); i++)
		if ((v[i].date == d1 || v[i].date > d1) && v[i].date < d2)
		{	cout << v[i].date << " " << v[i].text << endl;
			empty = false;
		}
	if (empty)
		cout << "No entries for that week" << endl;
}

int main()
{	Diary	di;
	char	ch;
	cout << "I to insert an entry, S to show a week's entries:" << endl;
	while (cin >> ch)
	{	switch (ch)
		{	case 'I' : case 'i' : di.add_entry(); break;
			case 'S' : case 's' : di.show_week(); break;
			default : return 0;
		}
		cout << "I, S or Q to quit" << endl;
	}
}