#include <iostream>

using namespace std;

int main() {

    // 입력
    int n;
    cin >> n; 
    
    // 필요한 변수 선언
    int cnt = 0;
    int i = 1;

    // 연산
    while (n > 0) {
        if (n - i < 0) {
            i = 1;
        } else {
            n -= i;
            i++;
            cnt++;
        }
    }

    // 출력
    cout << cnt;

    return 0;
}