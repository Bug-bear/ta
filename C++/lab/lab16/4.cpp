#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int vecprod(const vector<int>&, int);
	vector<int> intvec;
	for (int n = 0; n < 3; n ++)
		intvec.push_back(n+2);
	cout << vecprod(intvec, intvec.size()-1) << endl;
}




int vecprod(const vector<int>& ivec, int n)
{	if (n < 0)
		return 0;
	else if (n == 0)
		return ivec[0];
	else return (ivec[n] * vecprod(ivec, n-1));
}