#include <iostream>
#include <algorithm>

using namespace std;

// 필요 변수 선언
int N;
string str[200005];

// 입력
void input() {
    cin >> N;
    
    for (int i = 1; i <= N; i++) {
        cin >> str[i];
    }
}

// 실행
void pro() {
    sort(str + 1, str + 1 + N, [](const string &str1, const string &str2) {
        if (str1.size() != str2.size()) return str1.size() < str2.size();
        return str1 < str2;
    });
}

// 출력
void print() {
    for (int i = 1; i <= N; i++) {
        if (str[i] == str[i - 1]) continue;
        cout << str[i] << "\n";
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