#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 필요변수
int N, M;
vector<string> people;
int cnt = 0;

// 입력
void input() {
    cin >> N >> M;
    string name;
    for (int i = 0; i < N; i++) {
        cin >> name;
        people.push_back(name);   
    }
    // 정렬
    sort(people.begin(), people.end());
}

// 이분탐색
bool isIt(string person) {
    int left = 0, right = N - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        // 찾았다!
        if (people[mid] == person)   return true;

        if (people[mid] < person) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return false;
}

// 실행 및 출력
void pro() {
    string person;

    for (int i = 0; i < M; i++) {
        cin >> person;
        if (isIt(person)) {
            cnt++;
            people.push_back(person);
        }
    }

    sort(people.begin() + N, people.end());
    
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
    cout << cnt << "\n";

    for (int i = 0; i < cnt; i++) {
        cout << people[N + i] << "\n";
    }

}