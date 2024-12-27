#include <iostream>
using namespace std;

float jaccard(int a[], int b[], int m, int n){
   int s = 0;

   for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
         if(a[i] == b[j]){
            s++;
         }
      }
   }

   return static_cast<float>(s) / (m + n - s);
}

int main() {
   int t, m, n;

   cin >> t;
   for(int i = 0; i < t; i++){
      cin >> m >> n;

      int a[m];
      int b[n];

      for(int j = 0; j < m; j++){
         cin >> a[j];
      }

      for(int j = 0; j < n; j++){
         cin >> b[j];
      }
      cout << (jaccard(a, b, m, n) > 0.5) << endl;
   }
}