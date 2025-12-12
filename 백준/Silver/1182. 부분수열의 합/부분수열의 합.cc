#include <iostream>
#include <vector>

using namespace std;

// 변수선언
int N, S;
vector<int> nums(20, 0);
int cnt = 0;

// 입력
void input() {
    cin >> N >> S;

    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
}

// 풀이
void rec_func(int k, int ans) {
    // 다 고른 상태
    if (k == N) {
        // 총 합이 S와 같으면 cnt 증가
        if (ans == S) {
            cnt++;
        }
        return;
    }

    // 고를지 말지 선택
    for (int cand = 0; cand <= 1; cand++) {
        // 고르면 ans에 값 더하기
        if (cand) {
            ans += nums[k];
        }
        rec_func(k + 1, ans);
    }
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력 + 연산 + 출력
    input();
    rec_func(0, 0);

    // 아무 것도 안고른 경우 고려해서 출력
    cout << ((S == 0 && cnt != 0) ? (cnt - 1) : cnt);
    return 0;
}