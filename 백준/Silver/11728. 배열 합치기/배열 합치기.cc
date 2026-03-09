#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int A[1000005], B[1000005];

void input() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    sort(A, A + N);

    for (int i = 0; i < M; i++) {
        cin >> B[i];
    }
    sort(B, B + M);

}


void pro() {
    string ans = "";
    int idxA = 0, idxB = 0;
    while (idxA < N && idxB < M) {
        if (A[idxA] <= B[idxB]) {
            ans += to_string(A[idxA++]) + " ";
        } else {
            ans += to_string(B[idxB++]) + " ";
        }
    }

    if (idxA != N) {
        for (; idxA < N; idxA++) {
            ans += to_string(A[idxA]) + " ";
        }
    }

    if (idxB != M) {
        for (; idxB < M; idxB++) {
            ans += to_string(B[idxB]) + " ";
        }
    }
    
    // 정답 출력
    cout << ans;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}