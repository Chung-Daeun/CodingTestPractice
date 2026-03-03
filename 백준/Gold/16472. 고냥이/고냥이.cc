#include <iostream>

using namespace std;

// 변수
int N;
string str;
int alphabet[26];

void input() {
    cin >> N >> str;
}

void pro() {
    int cnt = 0, maxLength = 0;

    // right를 이동하면서 길이 늘려가기
    for (int left = 0, right = 0; right < str.length(); right++) {
        // right자리 글자 추가
        int idxR = str[right] - 'a';
        alphabet[idxR]++;

        // 사용한 문자 종류 체크
        if (alphabet[idxR] == 1)    cnt++;

        // 만약 cnt가 N보다 크다면 left로 길이를 줄여서 조건 만족시키기
        while (cnt > N) {
            int idxL = str[left] - 'a';
            if (alphabet[idxL] == 1)    cnt--;
            alphabet[idxL]--;
            left++;
        }

        // 길이 업데이트
        maxLength = max(right - left + 1, maxLength);
    }

    cout << maxLength;

    
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