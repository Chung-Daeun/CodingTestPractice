#include <iostream>
using namespace std;

int main() {
   int t, h, w, n, x, y;
   cin >> t ;
   string floor;

   for(int i = 0; i < t; i++){
      cin >> h >> w >> n;
      x = n / h + 1;
      y = n % h;
      if(y == 0){
         y = h;
         x -= 1;
      }
      floor = to_string(y);
      if(x >= 10){
         floor += to_string(x);
      } else {
         floor += ('0' + to_string(x));
      }
      cout << floor << endl;
   }
}