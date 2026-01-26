#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 필요변수
int N, C;
vector<int> houseList;
int cows = 0;

// 입력
void input() {
    cin >> N >> C;
    int house;
    for (int i = 0; i < N; i++) {
        cin >> house;
        houseList.push_back(house);
    }
}

bool determination(int dist) {
    int cnt = 1, last = houseList[0];

    for (int i = 1; i < N; i++) {
        // 간격이 적으면 스킵
        if (houseList[i] - last < dist) continue;

        cnt++;
        last = houseList[i];
    }
    return cnt >= C;
}

void pro() {
    // 칸 위치를 정렬하자
    sort(houseList.begin(), houseList.end());

    // 이분탐색 시작
    int left = 1, right = 1000000000;
    while (left <= right) {
        int mid = (left + right) / 2;

        if (determination(mid)) {
            cows = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
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
    cout << cows;

}