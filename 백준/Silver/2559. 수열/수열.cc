#include <iostream>
using namespace std;

int N, K;
int A[100005];

void input() {
    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
}


void pro() {
    int sum = 0;

    // 최초값 세팅
    for (int i = 0; i < K; i++) {
        sum += A[0 + i];
    }

    // 최초값으로 정답값 설정
    int maxSum = sum;

    // 한칸씩 이동하면서 값 확인하기
    for (int left = 0, right = K; right < N; left++, right++) {
        sum += A[right] - A[left];
        maxSum = max(sum, maxSum);
    }
     
    // 정답 출력
    cout << maxSum;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}