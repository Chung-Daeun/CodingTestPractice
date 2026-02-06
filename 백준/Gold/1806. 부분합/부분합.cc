#include <iostream>
#include <vector>

using namespace std;

// 변수
int N, S;
vector<int> nums;

void input() {
    cin >> N >> S;

    int temp;
    nums.push_back(0);
    for (int i = 0; i < N; i++) {
        cin >> temp;
        nums.push_back(temp);
    }

}

void pro() {
    int R = 1, ans = N + 1, sum = nums[1];

    for (int L = 1; L <= N; L++) {
        // L - 1을 빼기
        sum -= nums[L - 1];

        // S이상이 될때까지 더하기(R이동)
        while (sum < S && R + 1 <= N) {
            sum += nums[++R];
        }

        // 길이비교
        if (sum >= S) {
            ans = min(ans, R - L + 1);
        }
    }

    // 0인지 체크
    if (ans == N + 1) {
        ans = 0;
    }

    // 출력
    cout << ans;
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
}