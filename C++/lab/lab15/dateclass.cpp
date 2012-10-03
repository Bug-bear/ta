/* Definition and member functions for Date class */
/* "and" and "or" have been replaced with && and || for compatibility with Borland and g++ compilers */

#include <iostream>
#include <string>
#include <iomanip>
#include <cassert>
#include <cstdlib>
#include <ctime>
#include <sstream>

using namespace std;

class Month
{ public:
	char name[4];	// Can't do initialization if this is string
	int days;
};

class Date
{	friend istream& operator>>(istream& is, Date& d);
  public:
	Date();
	Date(int d, int m);
	void add_day();
	void print() const;
	bool precedes(const Date&) const;
	bool operator<(const Date&) const;
	bool operator==(const Date&) const;
	int operator-(const Date&) const;
	void operator<<(ostream&) const;

	bool operator>(const Date&) const;
	void daysplus(int);
	void operator+=(int);
  private:
	static const int NMTHS = 12;	// can also use globals
	static const Month months[];
	int daynum() const;
	int day;
	int month;

	static const int NDAYS = 365;
	Date numday(int) const;
};

const Month Date::months[NMTHS+1] = {{"", 0}, {"Jan", 31}, {"Feb", 28}, {"Mar", 31}, {"Apr", 30}, {"May", 31}, {"Jun", 30}, {"Jul", 31}, {"Aug", 31}, {"Sep", 30}, {"Oct", 31}, {"Nov", 30}, {"Dec", 31}};

Date::Date()
{	/*day = 1;
	month = 1;*/

	time_t hold_time = time(NULL);
	istringstream is(ctime(&hold_time));

	string mon, dump;
	int d;
	is>>dump>>mon>>d;

	for(int i=1; i<NMTHS+1; i++){
		if(months[i].name==mon)
			month=i;
	}
	day=d;
}

Date::Date(int d, int m)
{	if (m < 1 || m > NMTHS)
	{	cerr << "Invalid month value" << endl;
		exit(1);
	}
	if (d < 1 || d > months[m].days)
	{	cerr << "Invalid day value" << endl;
		exit(2);
	}
	// or you could use an assert:
	assert (m >= 1 && m <= NMTHS && d >= 1 && d <= months[m].days);
	day = d;
	month = m;
}

void Date::add_day()
{	if (day == months[month].days)
	{	day = 1;
		month = month % NMTHS + 1;
	}
	else day++;
}

void Date::print() const
{	cout << day;
	cout << " " << months[month].name << endl;
}

bool Date::precedes(const Date& d) const
{	return month < d.month || (month == d.month && day < d.day);
}

bool Date::operator<(const Date& d) const	// same as preceding, with op overload
{	return month < d.month || (month == d.month && day < d.day);
}

bool Date::operator==(const Date& d) const
{	return month == d.month && day == d.day;
}

int Date::daynum() const
{	int	dnum = 0;
	for (int i = 1; i < month; i++)
		dnum += months[i].days;
	dnum += day;
	return dnum;
}

int Date::operator-(const Date& d) const
{	return daynum() - d.daynum();
}

void Date::operator<<(ostream& os) const	// member function called by non-member function of same name
{	os << day << " " << months[month].name;
}

ostream& operator<<(ostream& os, const Date& d)	// non-member function
{	d.operator<<(os);
	return os;
}

istream& operator>>(istream& is, Date& dt)	// non-member friend function
{	cout << "Give me a day: ";
	int d;
	is >> d;
	if (is.fail())
		return is;
	cout << "and a month: ";
	int m;
	is >> m;
	assert (m >= 1 && m <= dt.NMTHS && d >= 1 && d <= dt.months[m].days);
	dt.day = d;
	dt.month = m;
	return is;
}

bool Date::operator>(const Date& d) const	// same as preceding, with op overload
{	return month > d.month || (month == d.month && day > d.day);
}

Date Date::numday(int daynumber) const
{	int	m, dn = daynumber;
	for (m = 1; dn > months[m].days; m++)
			dn -= months[m].days;
	return Date(dn, m);
}

void Date::daysplus(int extradays)
{	Date	newdate = numday((daynum() + extradays) % NDAYS);
	month = newdate.month;		// or replace these two lines by
	day = newdate.day;			// *this = newdate;
}

void Date::operator+=(int extradays)
{	Date	newdate = numday((daynum() + extradays) % NDAYS);
	month = newdate.month;		// or replace these two lines by
	day = newdate.day;			// *this = newdate;
}

