#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// 변수선언
int L, C;
string charList = "";
string str = "";
int c = 2;
int v = 1;

// 입력
void input() {
    cin >> L >> C;

    char c;
    for (int i = 0; i < C; i++) {
        cin >> c;
        charList += c;
    }

    // 받은 문자열 정렬
    sort(charList.begin(), charList.end());
}

// 자음 모음 관리
void countChar(int mode, char ch) {
    string vowels = "aeiou";
    bool isVowel = vowels.find(ch) != string::npos;

    if (mode) { // 문자열 추가
        if (isVowel) v--;
        else c--;
    } else {    // 문자열 삭제
        if (isVowel) v++;
        else c++; 
    }
}

// 풀이
void rec_func(int k, int idx) {
    if (k == L) {
        // 선택완료
        // 최소 자음, 모음 다 사용해야 출력
        if (c <= 0 && v <= 0) {
            cout << str << "\n";
        }

        // cout << str << "\n";
        return;
    }

    for (int cand = idx + 1; cand < C; cand++) {
        // 고른 글자를 정답 문자열에 추가
        str += charList[cand];
        // 자음, 모음 최소 갯수 감소
        countChar(1, charList[cand]);

        // 다음자리 찾기
        rec_func(k + 1, cand);

        // 글자 빼기
        str.pop_back();
        // 자음, 모음 최소 갯수 증가
        countChar(0, charList[cand]);
    }
    
}

int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력 + 연산
    input();
    rec_func(0, -1);

    
    return 0;
}