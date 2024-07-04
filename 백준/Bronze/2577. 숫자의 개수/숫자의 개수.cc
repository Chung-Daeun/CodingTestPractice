#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    
    string num = to_string(a * b * c);
    int arr[10] = {0};

    for(int i = 0; i < num.length(); i++){
        arr[num[i] - 48] += 1;
    }

    for(int i = 0; i < 10; i++){
        cout << arr[i] << endl;
    }


}
