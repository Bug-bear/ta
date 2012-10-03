#include <iostream>

#include <fstream>

#include <sstream>

#include <string>

#include <vector>

#include <cctype>
using namespace std;


void split (string in, string out1, string out2)

{

      ifstream infile;

      ofstream outfile1,outfile2;

      string line;

      string f1 = "nursery.txt";

      infile.open (f1);

      outfile1.open ("output1.txt");

      outfile2.open ("output2.txt");

      if (infile.fail())

      {

            cerr<<"Input failed";

            return ;

      }
      while (getline (infile,line))

      {

            char ch = line [0];

            if (ch == 'M' || ch < 'M')

                  outfile1<<line<<endl;
            else

                  outfile2<<line<<endl;


      }



      infile.close ();

      outfile1.close ();

      outfile2.close();
}

int main ()

{

      string a,b,c;

      split (a,b,c);

}