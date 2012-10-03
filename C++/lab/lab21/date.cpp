/* Definition and member functions for Date class */
/* "and" and "or" have been replaced with && and || for compatibility with g++ compiler */

#include <iostream>
#include <string>
#include <iomanip>
#include <cassert>
#include <cstdlib>

using namespace std;
#include "date.h"

const Month Date::months[NMTHS+1] = {{"", 0}, {"Jan", 31}, {"Feb", 28}, {"Mar", 31}, {"Apr", 30}, {"May", 31}, {"Jun", 30}, {"Jul", 31}, {"Aug", 31}, {"Sep", 30}, {"Oct", 31}, {"Nov", 30}, {"Dec", 31}};

Date::Date()
{	day = 1;
	month = 1;
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

void Date::add_day(void)
{	if (day == months[month].days)
	{	day = 1;
		month = month % NMTHS + 1;
	}
	else day++;
}

void Date::print(void) const
{	cout << day;
	cout << " " << months[month].name << endl;
}

bool Date::precedes(Date d) const
{	return month < d.month || (month == d.month && day < d.day);
}

bool Date::operator<(Date d) const	// same as preceding, with op overload
{	return month < d.month || (month == d.month && day < d.day);
}

bool Date::operator==(Date d) const
{	return month == d.month && day == d.day;
}

int Date::daynum(void) const
{	int	dnum = 0;
	for (int i = 1; i < month; i++)
		dnum += months[i].days;
	dnum += day;
	return dnum;
}

int Date::operator-(Date d) const
{	return daynum() - d.daynum();
}

ostream& operator<<(ostream& os, const Date& d)	// non-member friend function
{	os << d.day;
	os << " " << d.months[d.month].name;
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


