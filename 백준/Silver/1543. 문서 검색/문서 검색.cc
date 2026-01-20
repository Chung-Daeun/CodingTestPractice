#include <iostream>
// #include <string>

using namespace std;

string text, word;

void input() {
    getline(cin, text);
    getline(cin, word);
}

void pro() {
    size_t idx = 0;
    int ans = 0;

    while (1) {
        size_t pos = text.find(word, idx);
        if (pos == string::npos) break;
        ans++;
        idx = pos + word.length();
    }
    
    cout << ans;
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