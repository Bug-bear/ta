#include "ccc_empl.cpp"
#include <iostream>
#include <iomanip>
using namespace std;

int main(){
	string nm;
	int sal;

	cout<<"Plz enter name and salary for the 1st"<<endl;
	cin>>nm>>sal;
	Employee emp1(nm, sal);
  	cout<<"Plz enter name and salary for the 2nd"<<endl;
	cin>>nm>>sal;
	Employee emp2(nm, sal);
	cout<<"Plz enter name and salary for the 3rd"<<endl;
	cin>>nm>>sal;
	Employee emp3(nm, sal);

	cout<<"The salary of "<<emp1.get_name()<<" is "<<emp1.get_salary()<<endl;
	cout<<"The salary of "<<emp2.get_name()<<" is "<<emp2.get_salary()<<endl;
	cout<<"The salary of "<<emp3.get_name()<<" is "<<emp3.get_salary()<<endl;

	cout<<setw(5)<<"Name"<<setw(10)<<"Annual"<<setw(10)<<"Monthly"<<endl;
	cout<<setw(5)<<emp1.get_name()<<setw(10)<<emp1.get_salary()<<setw(10)<< fixed << setprecision(2)<<(double)emp1.get_salary()/12<<endl;
	cout<<setw(5)<<emp2.get_name()<<setw(10)<<emp2.get_salary()<<setw(10)<< fixed << setprecision(2)<<(double)emp2.get_salary()/12<<endl;
	cout<<setw(5)<<emp3.get_name()<<setw(10)<<emp3.get_salary()<<setw(10)<< fixed << setprecision(2)<<(double)emp3.get_salary()/12<<endl;

	cout<<"The average monthly salary is "<< (double)(emp1.get_salary()+emp2.get_salary()+emp3.get_salary())/12/3<<endl;
}