#include <iostream>
#include <string>
// #include <algorithm>

using namespace std;

int main() {
    
    // 필요 상수 선언
    const unsigned char arr[10] = {0, 7, 4, 1, 8, 5, 2, 9, 6, 3};

    // 필요 변수 선언
    string str;
    int idx;
    int sum = 0;

    // 입력
    cin >> str;

    // 풀이
    idx = str.find("*");

    for (int i = 0; i < 13; i++) {
        if (str[i] == '*') {
            continue;
        }

        if (i % 2 == 0) {
            sum += str[i] - '0';
        } else {
            sum += 3 * (str[i] - '0');
        }
    }

    int ans = 10 - (sum % 10);
    
    if (ans == 10) {
        ans = 0;
    }

    if (idx % 2 == 1) {
        ans = arr[ans];
    }

    cout << ans;

    return 0;
}