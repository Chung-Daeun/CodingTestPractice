#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// 필요 변수 선언
int N;
vector<int> dots[5005];
int ans = 0;

// 입력
void input() {
    cin >> N;
    int dot, color;
    for (int i = 0; i < N; i++) {
        cin >> dot >> color;
        dots[color].push_back(dot);
    }
}

// 실행
void pro() {
    int sz;
    // 색상별로 정렬 및 계산
    for (int i = 1; i <= N; i++) {
        sz = dots[i].size();
        // size가 0이거나 1이면 스킵
        if (sz == 0 || sz == 1) continue;

        // 정렬
        sort(dots[i].begin(), dots[i].end());

        // 길이 계산
        ans += dots[i][1] - dots[i][0]; // 제일 처음 점
        ans += dots[i][sz - 1] - dots[i][sz - 2];  // 제일 마지막 점

        for (int j = 1; j < dots[i].size() - 1; j++) {
            ans += min(dots[i][j] - dots[i][j - 1], dots[i][j + 1] - dots[i][j]);
        }
    }

}

// 출력
void print() {
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

    // 출력
    print();
    return 0;
}