#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int N;
long long A[5005];

void input() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    sort(A, A + N);
}

void pro() {
    long long bestSum = 0x7fffffffffffffff;
    int v1 = -1, v2 = -1, v3 = -1;

    for (int cand = 0; cand < N - 2; cand++) {
        int left = cand + 1, right = N - 1;

        while (left < right) {
            long long sum = A[cand] + A[left] + A[right];
            
            if (bestSum > abs(sum)) {
                bestSum = abs(sum);
                v1 = cand;
                v2 = left;
                v3 = right;
            }

            if (sum > 0) {
                right--;
                continue;
            } 

            if (sum < 0) {
                left++;
                continue;
            }

            if (sum == 0) {
                break;
            }
        }
    }

    cout << A[v1] << " " << A[v2] << " " << A[v3];
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    pro();
}