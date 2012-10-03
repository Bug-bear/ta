#include <iostream>

using namespace std;

int main(){

	int x, y, n;
/*	cin >> n;
	if (cin.fail())
		return 1;
	x = n;
	cin >> n;
	if (cin.fail())
		return 1;
	if (n > x){
		y = x;
		x = n;
	}
	else y = n;

	while (cin >> n){
		if (n > x){
			y = x;
			x = n;
		}
		else if (n > y)
			y = n;
	}*/

	while(cin>>x>>y){
		if (cin.fail())
			return 1;

		if(x<y){
			n = x;
			x = y;
			y = n;
		}
		cout << x << " " << y << endl;
	}


}

