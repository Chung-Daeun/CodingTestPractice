#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int A[100005];

void input() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    sort(A, A + N);
}


void pro() {
    int minSub = A[N - 1] - A[0];

    for (int left = 0, right = 1; left < N - 1; left++) {
        while (right < N && A[right] - A[left] < M) {
            right++;
        }

        if (A[right] - A[left] >= M) {
            minSub = min(minSub, A[right] - A[left]);
        }
    }
    
    // 정답 출력
    cout << minSub;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}