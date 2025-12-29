#include <iostream>
#include <vector>

using namespace std;

// 변수선언
int N;
vector<vector<int>> tri;
int maxSum = 0;
int sum = 0;

void input() {
    cin >> N;

    int num;

    for (int i = 0; i < N; i++) {
        vector<int> v;
        for (int j = 0; j <= i; j++) {
            cin >> num;
            v.push_back(num);
        }
        tri.push_back(v);
    }
}

void pro(int r, int c) {
    // 다골랐다!
    if (r == N) {
        maxSum = max(maxSum, sum);
        return;
    }
    // 삼각형 밖으로 나감
    if (c == r + 1) {
        return;
    }

    // 한줄씩 내려가면서 연산
    sum += tri[r][c];

    // 대각선 왼쪽으로 이동
    pro(r + 1, c);

    // 대각선 오른쪽으로 이동
    pro(r + 1, c + 1);

    // sum 원상복구
    sum -= tri[r][c];

}

void print() {
    cout << maxSum;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력
    input();
    // 실행
    pro(0, 0);
    // 출력
    print();

}
