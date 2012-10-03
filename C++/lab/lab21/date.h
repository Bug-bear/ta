#include <iostream>
#include <string>
#include <iomanip>
#include <cassert>
#include <cstdlib>

//using namespace std;

class Month
{ public:
	char name[4];	// Can't do initialization if this is string
	int days;
};

class Date
{	friend istream& operator>>(istream& is, Date& d);
	friend ostream& operator<<(ostream& os, const Date& d);
 public:
	Date();
	Date(int d, int m);
	void add_day(void);
	void print(void) const;
	bool precedes(Date) const;
	bool operator<(Date) const;
	bool operator==(Date) const;
	int operator-(Date) const;
  private:
	static const int NMTHS = 12;	// can also use globals
	static const Month months[];
	int daynum(void) const;
	int day;
	int month;
};
