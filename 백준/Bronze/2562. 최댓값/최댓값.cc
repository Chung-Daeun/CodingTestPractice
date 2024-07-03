#include <iostream>
using namespace std;

int main(){
    int num, n;
    int max = 0;

    for(int i = 1; i <= 9; i++){
        cin >> num;
        if(max < num){
            max = num;
            n = i;
        }
    }

    cout << max << endl << n << endl;
}