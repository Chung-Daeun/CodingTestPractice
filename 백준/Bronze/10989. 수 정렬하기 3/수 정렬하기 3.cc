#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // 필요 변수 선언
    int n, k;
    int arr[10001] = {0, };

    // 입력 및 연산
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> k;
        arr[k] += 1;
    }

    for (int i = 1; i <= 10000; i++) {
        if (arr[i] != 0) {
            for (int j = 0; j < arr[i]; j++) {
                cout << i << "\n";
            }
        }
    }
    return 0;
}