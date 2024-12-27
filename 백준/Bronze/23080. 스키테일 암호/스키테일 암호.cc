#include <iostream>
#include <string>
using namespace std;

int main() {
   int num;
   string str;

   cin >> num >> str;

   for(size_t i = 0; i < str.length(); i += num){
      cout << str[i];
   }
}