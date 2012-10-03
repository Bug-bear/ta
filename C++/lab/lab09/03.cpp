#include <iostream>
#include <fstream>
#include <vector>
#include <assert>

using namespace std;

class Postcard
{
	public:
		Postcard(){};
		Postcard(string,string,string);
		void print() const;
	private:
		string receiver ;
		string place;
		string sender;
};

Postcard::Postcard(string a,string b,string c){
	receiver=a;
	place=b;
	sender=c;
}

void Postcard::print() const
{
   cout << "Dear " << receiver << endl;
   cout << "Having a lovely time at " << place << endl;
   cout << "Wish you were here\n";
   cout << "From " << sender << endl;
}

int main( )
{
	string a,b,c;

	Postcard m;

	cout<<"receiver"<<endl;
	cin>>a;
	cout<<"place"<<endl;
	cin>>b;
	cout<<"sender"<<endl;
	cin>>c;

	Postcard n(a,b,c);

	m.print();
	n.print();
}