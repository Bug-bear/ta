#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>

//using namespace std;

class Out_of_bounds{
	public:
		Out_of_bounds(int n):bvalue(n){}
		int badval() const{return bvalue;}
	private:
		int bvalue;
};

class Pop_on_empty{};

template<typename T>
class Bivec
{ public:
	Bivec() {low = 0;}
	Bivec(int lo, int hi, T initial_value);
	void push_back(T);
	void push_front(T);
	T pop_back() throw (Pop_on_empty);
	T pop_front() throw (Pop_on_empty);
	T& operator[](int) throw (Out_of_bounds);
	void display() const;
	bool empty() const {return v.size() == 0; }

	Bivec(const Bivec& bx) { copy(bx); }
	~Bivec() { free(); }
	const Bivec& operator=(const Bivec&);
  private:
	vector<T*> v;
	int low;
	void copy(const Bivec&);
	void free();
};