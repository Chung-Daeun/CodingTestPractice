#include <iostream>
#include <string>
// #include <cmath>

using namespace std;

int main() {
    // 필요 변수 선언
    int t, k, n;
    int apt[15][15];

    for (int i = 0; i < 15; i++) {
        for (int j = 1; j < 15; j++) {
            if (i == 0) {
                apt[i][j] = j;
                continue;
            }

            apt[i][j] = 0;
            for (int k = 1; k <= j; k++) {
                apt[i][j] += apt[i - 1][k];
            }
        }
    }

    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> k >> n;
        cout << apt[k][n] << endl;
    }

    return 0;
}