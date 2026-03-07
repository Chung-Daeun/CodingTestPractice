#include <iostream>
using namespace std;

int N;
long long M;
int A[10005];

void input() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
}


void pro() {
    int cnt = 0;
    long long sum = 0;
    
    for (int left = 0, right = 0; left < N; left++) {
        // 합이 M보다 작으면 다음 수 더하기
        while (right < N && sum < M) {
            sum += A[right++];
        }

        // M과 같으면 정답에 추가
        if (sum == M)   cnt++;

        // A[left] 제외해서 다음수부터 더하는 거 탐색
        sum -= A[left];
    }

    // 정답 출력
    cout << cnt;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}