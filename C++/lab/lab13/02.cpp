#include <iostream>
#include <assert>
#include <vector>
#include <iomanip>

using namespace std;

int main(){
	vector<vector<int> > v2(4,vector<int>(5));
	for(int i=0; i<4; i++){
		for(int j=0; j<5; j++){
			v2[i][j]=j+i*10;
		}
	}

	for(int i=0; i<4; i++){
		for(int j=0; j<5; j++){
			cout<<setw(3)<<v2[i][j];
		}
		cout<<endl;
	}

	for(int j=0; j<5; j++){
		for(int i=0; i<4; i++){
			cout<<setw(3)<<v2[i][j];
		}
		cout<<endl;
	}
}