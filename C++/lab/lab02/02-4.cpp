#include "ccc_empl.cpp"
#include <iostream>
using namespace std;

int main(){
	int pay = 16484;
	int payrise = 2500;
	string nm = "peng";
	Employee emp(nm, pay);
	cout<<"The salary of "<<emp.get_name()<<" is "<<emp.get_salary()<<endl;
	emp.set_salary(pay+payrise);
	cout<<"The new salary of "<<emp.get_name()<<" is "<<emp.get_salary()<<endl;
}