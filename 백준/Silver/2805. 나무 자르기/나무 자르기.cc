#include <iostream>
#include <deque>

using namespace std;


// 필요변수
int N, M;
int trees[1000005];
int H = 0;

// 입력
void input() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> trees[i];
    }
}

void pro() {
    int left = 0;
    int right = 1000000000;

    while (left <= right) {
        int mid = (left + right) / 2;
        // 잘라낸 나무의 총합
        long long newTreeGroup = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > mid) {
                newTreeGroup += trees[i] - mid;
            }
        }

        if (newTreeGroup < M) {
            right = mid - 1;
        } else {
            H = mid;
            left = mid + 1;
        }
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
    cout << H;

}