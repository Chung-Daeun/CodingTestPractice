#include <iostream>
#include <vector>

using namespace std;

// 변수선언
int N;
vector<int> cols(15, 0);
int ans = 0;

// 입력
void input() {
    cin >> N;
}

// 가능성 체크
bool valid(int k, int col) {
    // 앞선 줄에 있는 말을 모두 비교해야함.
    for (int i = 0; i < k; i++) {
        // 같은 세로 줄에 있으면 공격 가능
        if (col == cols[i]) return false;
        // 왼쪽 위 대각선에 있으면 공격 가능
        if (k - col == i - cols[i]) return false;
        // 오른쪽 위 대각선에 있으면 공격 가능
        if (k + col == i + cols[i]) return false;
    }
    return true;
}

// 풀이
void rec_func(int k) {
    // 퀸을 다 놓은 상태
    if (k == N) {
        ans++;
        return;
    }

    // 퀸 놓기
    for (int col = 0; col < N; col++) {
        // 첫 줄은 아무데나 놓을 수 있고 다른 줄은 가능성을 체크해야한다.
        // 가능성 체크 함수에서 첫줄 여부도 처리 가능해 보인다.
        if (valid(k, col)) {
            cols[k] = col;
            rec_func(k + 1);
            continue;
        }
    }

}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력 + 연산 + 출력
    input();
    rec_func(0);
    cout << ans;
    return 0;
}