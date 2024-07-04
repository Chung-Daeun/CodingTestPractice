#include <iostream>
using namespace std;

int main() {
    int num, x, min, max;
    cin >> num;
    cin >> x;
    min = max = x;

    for(int i = 1; i < num; i++) {
        cin >> x;
        if (min > x) {
            min = x;
        }
        if (max < x) {
            max = x;
        }
    }

    cout << min << " " << max;
}
