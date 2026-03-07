#include <iostream>
using namespace std;

int N, K;
int A[1000005];

void input() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
}


void pro() {
    int groupSize = N + 1, cnt = 0;

    for (int left = 0, right = 0; left < N; left++) {
        // 조건이 충족될 때까지 인형을 추가한다.
        while (right < N && cnt < K) {
            if (A[right++] == 1) {
                cnt++;
            }
        }

        // 조건이 충족한다면 그룹 크기를 비교한다.
        if (cnt >= K) {
            groupSize = min(groupSize, right - left);
        }

        // 확인했으니 다음을 위해 left 제외
        if (A[left] == 1)   cnt--;
    }

    // 정답 출력
    cout << (groupSize == N + 1 ? -1 : groupSize); 
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}