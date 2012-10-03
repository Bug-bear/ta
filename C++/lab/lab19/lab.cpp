#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

class Worker{
	public:
		virtual void print() const=0;
	protected:
		Worker(string, double);
		virtual double compute_pay() const=0;
		double rate;
		static const int WEEKLY_HOURS = 40;
	private:
		string name;
};

class Hourlyworker : public Worker{
	public:
		Hourlyworker(string, double, int);
		virtual double compute_pay() const;
		virtual void print() const;
	private:
		int hour_num;
};

class Salariedworker : public Worker{
	public:
		Salariedworker(string, double);
		virtual double compute_pay() const;
		virtual void print() const;

};

Worker::Worker(string n, double r) : name(n), rate(r){}

void Worker::print() const{
	cout<<name<<endl;
	cout<< fixed << setprecision(2)<<"Rate: "<<rate<<" , ";
}

Hourlyworker::Hourlyworker(string s, double r, int n)
	: Worker(s, r), hour_num(n){}

double Hourlyworker::compute_pay() const{
	const double OVERTIME_RATE = 1.5;
	if(hour_num<WEEKLY_HOURS) return hour_num*rate;
	else return (WEEKLY_HOURS*rate+(hour_num-WEEKLY_HOURS)*OVERTIME_RATE);
}

void Hourlyworker::print() const{
	cout<<"Hourlyworker: ";
	Worker::print();
	cout<<"Hours: "<<hour_num<<" , ";
	cout<< fixed << setprecision(2)<<"Paid: "<<compute_pay()<<endl;

}

Salariedworker::Salariedworker(string s, double r) : Worker(s, r){}

double Salariedworker::compute_pay() const{
	return WEEKLY_HOURS*rate;
}

void Salariedworker::print() const{
	cout<<"Salariedworker: ";
	Worker::print();
	cout<< fixed << setprecision(2)<<"Paid: "<<compute_pay()<<endl;

}

int main()
{
	vector<Worker*> payroll;
	char code;

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

	for (int i = 0; i < payroll.size(); i++)
		payroll[i]->print();
}