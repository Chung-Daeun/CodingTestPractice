#include <iostream>
#include <algorithm>

using namespace std;


// 변수 선언
int T, N, M;
int A[20005], B[20005];
int idx, ans;
// string ans = "";

// 입력
void input() {
    cin >> N >> M;

    // A
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    // B
    for (int i = 0; i < M; i++) {
        cin >> B[i];
    }

    // B 정렬
    sort(B, B + M);
}

// 실행 + 출력
void pro() {
    ans = 0;
    for (int i = 0; i < N; i++) {
        ans += lower_bound(B, B + M, A[i]) - B;
    }

    // 출력
    cout << ans << "\n";

}


// 메인
int main () {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 실행
    cin >> T;
    for (int i = 0; i < T; i++) {
        input();
        pro();
    }
}