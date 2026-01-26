#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 필요변수
int N;
int nums[100005];

// 입력
void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    // 정렬
    sort(nums, nums + N);
}

// 이분탐색
bool isIt(int n) {
    int left = 0, right = N - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        // 찾았다!
        if (nums[mid] == n)   return true;

        if (nums[mid] < n) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return false;
}

// 실행 및 출력
void pro() {
    // 확인할 숫자 갯수
    int M, num;
    cin >> M;

    for (int i = 0; i < M; i++) {
        cin >> num;
        cout << isIt(num) << "\n";
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

}