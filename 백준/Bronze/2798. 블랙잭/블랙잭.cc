#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    // 입력
    int n, m;
    cin >> n >> m;
    int arr[n];

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // 필요 변수 선언
    int maxSum = 0;
    int sum;

    // 정렬
    sort(arr, arr + n);

    // 연산
    for (int i = 0; i < n - 2; i++) {
        // 하나 골랐는데 최대값 넘으면 반복 취소
        if (arr[i] >= m) {
            break;
        }

        for (int j = i + 1; j < n - 1; j++) {
            // 두개 골랐는데 최대값 넘으면 반복 취소
            if (arr[i] + arr[j] >= m) {
                break;
            }

            for (int k = j + 1; k < n; k++) {
                sum = arr[i] + arr[j] + arr[k];
                if (m >= sum) {
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                    continue;
                }

                // 범위 넘으면 반복 취소
                break;
            }
        }
    }

    // 출력
    cout << maxSum;

    return 0;
}