#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    // 상수선언
    const int R = 31;
    const int M = 1234567891;

    // 필요 변수 선언
    int n;
    string str;
    int temp = 0;

    // 입력
    cin >> n >> str;

    // 연산
    for (int i = 0; i < str.length(); i++) {
        temp += (str[i] - 'a' + 1) * pow(R, i);
    }

    // 출력
    cout << temp % M;
    return 0;
}