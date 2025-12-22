#include <iostream>
#include <algorithm>
using namespace std; 

// 변수 선언
int N;
long card[100000];
long mode;

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> card[i];
    }
}

void pro() {
    // 정렬
    sort(card, card + N);

    // 필요변수 선언
    mode = card[0];
    int modeCnt = 1, curCnt = 1;
    // 배열 탐색
    for (int i = 1; i < N; i++) {
        // 현재 숫자 갯수 측정
        if (card[i] == card[i - 1]) {
            curCnt++;
        } else {
            curCnt = 1;
        }

        // 이전 최고 값과 비교
        if (curCnt > modeCnt) {
            modeCnt = curCnt;
            mode = card[i];
        }
    }

}

void print() {
    cout << mode;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력
    input();
    // 실행
    pro();
    // 출력
    print();

    return 0;
}