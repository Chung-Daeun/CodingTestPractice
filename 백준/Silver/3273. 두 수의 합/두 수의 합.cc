#include <iostream>
#include <algorithm>
using namespace std;

int N, X;
int A[100005];

void input() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    sort(A, A + N);

    cin >> X;
}


void pro() {
    int left = 0, right = N - 1, cnt = 0;

    while (left < right) {
        int sum = A[left] + A[right];

        if (sum == X) {
            cnt++;
            left++;
            continue;
        }

        if (sum > X) {
            right--;
        } else {
            left++;
        }
    }

    cout << cnt;
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}