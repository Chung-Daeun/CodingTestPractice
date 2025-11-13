#include <iostream>
#include <cmath>

using namespace std;

int main() {

    // 입력
    int n;
    cin >> n; 

    // 필요변수 선언
    int i = 0;
    int k = 1;
    
    // 연산
    while (k < n) {
        k += 6 * ++i;
        // cout << "i: " << i << endl;
    }

    // 출력
    cout << i + 1;

    return 0;
}