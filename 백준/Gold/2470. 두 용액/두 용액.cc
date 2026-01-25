#include <iostream>
#include <algorithm>

using namespace std;

string text, word;

int N;
int arr[100005];

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
}

int lower_bound(int arr[], int left, int right, int target) {
    int res = right + 1;
    
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] >= target) {
            res = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return res;
}

void pro() {
    sort(arr, arr + N);

    int bestSum = 0x7fffffff;
    int ans1 = 0;
    int ans2 = 1;

    for (int i = 0; i < N - 1; i++) {
        int j = lower_bound(arr, i + 1, N - 1, -arr[i]);

        // j - 1이랑 j 둘다 비교해야함.(인덱스 범위 넘어가지 않도록 주의)
        if (i < j - 1 && abs(arr[i] + arr[j - 1]) < bestSum) {
            bestSum = abs(arr[i] + arr[j - 1]);
            ans1 = i;
            ans2 = j - 1;
        }

        if (j < N && abs(arr[i] + arr[j]) < bestSum) {
            bestSum = abs(arr[i] + arr[j]);
            ans1 = i;
            ans2 = j;
        }

        

    }

    cout << arr[ans1] << " " << arr[ans2];
    
}

int main() {
    // 입출력 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력
    input();
    // 실행
    pro();

}