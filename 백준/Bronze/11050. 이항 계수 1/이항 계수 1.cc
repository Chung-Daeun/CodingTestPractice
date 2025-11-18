#include <iostream>
// #include <algorithm>

using namespace std;

int main() {
    
    // 필요 변수 선언
    int n, k;
    int ans = 1;

    // 입력
    cin >> n >> k;

    if (k > (n / 2)) {
        k = n - k;
    }

    for (int i = 0; i < k; i++) {
        ans *= (n - i);
    }

    for (int i = k; i > 1; i--) {
        ans /= i;
    }

    cout << ans;

    return 0;
}