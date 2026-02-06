#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 변수
int N;
vector<int> v;

void input() {
    cin >> N;

    int temp;
    for (int i = 0; i < N; i++) {
        cin >> temp;
        v.push_back(temp);
    }

    // 정렬
    sort(v.begin(), v.end());

}

void pro() {
    int L = 0, R = N - 1, best_sum = 0x7fffffff;
    int s1, s2;

    while (L < R) {
        int sum = v[L] + v[R];

        // 정답 갱신
        if (abs(best_sum) > abs(sum)) {
            s1 = v[L];
            s2 = v[R];
            best_sum = sum;
        }

        // L, R 이동
        if (sum > 0)    R--;
        if (sum < 0)    L++;
        if (sum == 0)   break;
    }

    // 출력
    cout << s1 << " " << s2;
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