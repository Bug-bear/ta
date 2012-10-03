#include <iostream>
#include <iomanip>

using namespace std;

#include "ccc_time.cpp"

main(void)
{	Time now;
	const int interval = 30 * 60; // seconds in 30 minute interval
	cout << "Current time ";
	cout << now.get_hours() << ":" << now.get_minutes() << ":" << now.get_seconds() << endl;
	for (int i = 0; i < 10; i++)
	{	now.add_seconds(interval);
		cout << now.get_hours() << ":" << now.get_minutes() << ":" << now.get_seconds() << endl;
	}
}
