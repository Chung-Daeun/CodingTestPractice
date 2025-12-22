#include <iostream>
#include <algorithm>
using namespace std;

// 변수 선언
int N;
struct Elem {
    int idx, num;
    bool operator<(const Elem &rhs) const {
        if (num != rhs.num) return num < rhs.num;
        return idx < rhs.idx;
    }
} e[50];
int ans[50];

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        e[i].idx = i;
        cin >> e[i].num;
    }
}

void pro() {
    sort(e, e + N);

    for (int i = 0; i < N; i++) {
        ans[e[i].idx] = i;
    }
}

void print() {
    for (int i = 0; i < N; i++) {
        cout << ans[i] << " "; 
    }
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