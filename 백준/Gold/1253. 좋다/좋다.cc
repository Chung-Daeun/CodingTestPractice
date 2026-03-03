#include <iostream>
#include <algorithm>

using namespace std;

// 변수
int N;
int nums[2005];

void input() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    // 정렬
    sort(nums, nums + N);
}

bool search_number(int idx) {
    int left = 0, right = N - 1;

    while (left < right) {
        // idx랑 같으면 값 이동
        if (left == idx) {
            left++;
            continue;
        }

        if (right == idx) {
            right--;
            continue;
        }

        int sum = nums[left] + nums[right];

        // 찾았다!
        if (sum == nums[idx]) {
            return true;
        }

        // 못찾으면 포인트 이동
        if (sum < nums[idx]) {
            left++;
            continue;
        }

        if (sum > nums[idx]) {
            right--;
            continue;
        }
    }

    // 찾지 못하고 while문 끝나면 없는 것
    return false;
}

void pro() {
    int cnt = 0;

    for (int i = 0; i < N; i++) {
        if (search_number(i)) {
            cnt++;
        }
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