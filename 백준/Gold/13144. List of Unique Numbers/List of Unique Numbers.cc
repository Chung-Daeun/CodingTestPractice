#include <iostream>
#include <vector>

using namespace std;

// 변수
int N;
vector<int> v;
int nums[100000 + 1];

void input() {
    cin >> N;

    int temp;
    v.push_back(0);
    for (int i = 0; i < N; i++) {
        cin >> temp;
        v.push_back(temp);
    }
}

void pro() {
    int R = 0;
    long long cnt = 0;

    for (int L = 1; L <= N; L++) {
        // L - 1 제거
        nums[v[L - 1]] = 0;

        // 같은 수 나올 때까지 R 증가
        while (R + 1 <= N && nums[v[R + 1]] == 0) {
            nums[v[++R]]++;
        }

        cnt += R - L + 1;
    }

    // 출력
    cout << cnt;
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