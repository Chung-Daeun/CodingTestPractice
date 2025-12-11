#include <iostream>
#include <vector>

using namespace std;

int N, M;
vector<int> v(8,0);

// 입력
void input() {
    // 입력
    cin >> N >> M;
}

// 연산
void rec_func(int k) {
    if (k == M) {
        // 다 골랐다 출력하자!
        for (int i = 0; i < M; i++) {
            cout << v[i] << " ";
        }
        cout << "\n";
    } else {
        // 골라보자
        for (int i = 1; i <= N; i++) {
            if (i < v[k - 1]) {
                continue;
            }

            v[k] = i;
            rec_func(k + 1);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    rec_func(0);
    return 0;
}