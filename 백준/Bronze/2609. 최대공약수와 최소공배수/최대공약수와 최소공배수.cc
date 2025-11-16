#include <iostream>
#include <string>
// #include <cmath>

using namespace std;

int findGCD(int a, int b) {
    if (a % b == 0) {
        return b;
    }

    return findGCD(b, a % b);
}

int main() {
    // 필요 변수 선언
    int gcd;    // 최대공약수
    int lsm;    // 최소공배수

    int a, b;   // 입력 수

    // 입력
    cin >> a >> b;

    // 연산
    // 최대공약수 구하기
    gcd = findGCD(max(a, b), min(a, b));
    lsm = a * b / gcd;

    // 출력
    cout << gcd << endl << lsm;

    return 0;
}