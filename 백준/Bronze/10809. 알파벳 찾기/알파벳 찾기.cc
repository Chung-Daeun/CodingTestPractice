#include <iostream>
using namespace std;

int main() {
   string s;
   cin >> s;

   for(char c = 'a'; c <= 'z'; c++){
      if(s.find(c) >= s.length()){
         cout << -1 << " ";
      } else {
         cout << s.find(c) << " ";
      }
   }
}