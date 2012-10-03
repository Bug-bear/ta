#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

class Worker
{
	public:	
		virtual void print() const;		
	protected:
		virtual double compute_pay() const = 0;
		Worker(string, double);
		double get_rate() const {return rate;}
		static const int WEEKLY_HOURS = 40;
	private:
		string name;
		double rate;
};

class Hourlyworker : public Worker
{
	public:
		Hourlyworker(string, double, int);
		virtual double compute_pay() const;
		virtual void print() const;
	private:
		int hours;
};

class Salariedworker : public Worker
{
	public:
		Salariedworker(string, double);
		virtual double compute_pay() const;
		virtual void print() const;
};

/* *** Member functions for base class Worker *** */
	
Worker::Worker(string n, double r) : name(n), rate(r)
{}

void Worker::print() const
{
	cout << name << endl;
	cout << fixed << setprecision(2) << "Rate: " << rate << ", ";
}


/* *** Member functions for derived class HourlyWorker *** */

		
Hourlyworker::Hourlyworker(string n, double r, int h)
	: Worker(n, r), hours(h)
{}

double Hourlyworker::compute_pay() const
{	
	const double OVERTIME_RATE = 1.5;
	double rt = get_rate();
	if (hours <= WEEKLY_HOURS)
		return rt * hours;
	else
	{
		double norm = WEEKLY_HOURS * rt;
		double otime = (hours - WEEKLY_HOURS) * (rt * OVERTIME_RATE);
		return norm + otime;
	}
}

void Hourlyworker::print() const
{
	cout << "Hourly Paid: ";
	Worker::print();
	cout << "Hours: " << hours << ", ";
	cout  << fixed << setprecision(2) << "Pay: " << compute_pay() << endl << endl;
}

/* *** Member functions for derived class Salariedworker *** */

		
Salariedworker::Salariedworker(string s, double r)
	: Worker(s, r)
{}

double Salariedworker::compute_pay() const
{
	return get_rate() * WEEKLY_HOURS;
}

void Salariedworker::print() const
{
	cout << "Salaried: ";
	Worker::print();
	cout << fixed << setprecision(2) << "Pay: " << compute_pay();
	cout << endl << endl;
}


/* *** Main for testing *** */

int main()
{
	vector<Worker*> payroll;
	char code;
//	read details from file
	while (cin >> code)
	{
		string name;
		cin >> name;
		double rt;
		cin >> rt;
		
		if (code == 'H')
		{	int hrs;
			cin >> hrs;
			payroll.push_back(new Hourlyworker(name, rt, hrs));
		}
		else
			payroll.push_back(new Salariedworker(name, rt));
		cin.ignore();
	}	
			
//print payroll	
	
	for (int i = 0; i < payroll.size(); i++)
		payroll[i]->print();
}
	
	

	
