#include <iostream>
// #include <string>

using namespace std;

int h1, h2, m1, m2, s1, s2;
string temp;

void input() {
    cin >> temp;

    h1 = (int)temp[0] * 10 + (int)temp[1];
    m1 = (int)temp[3] * 10 + (int)temp[4];
    s1 = (int)temp[6] * 10 + (int)temp[7];

    cin >> temp;

    h2 = (int)temp[0] * 10 + temp[1];
    m2 = (int)temp[3] * 10 + temp[4];
    s2 = (int)temp[6] * 10 + temp[7];
    
}

void pro() {
    // 초 계산
    int s3 = s2 - s1;
    if (s3 < 0) {
        s3 += 60;
        m2 -= 1;
    }

    // 분 계산
    int m3 = m2 - m1;
    if (m3 < 0) {
        m3 += 60;
        h2 -= 1;
    }

    // 시간 계산
    int h3 = h2 - h1;
    if (h3 < 0) {
        h3 += 24;
    }
    if (h3 == 0 && m3 == 0 && s3 == 0) h3 = 24;
    
    cout << (h3 < 10 ? ("0" + to_string(h3)) : to_string(h3)) << ":" << (m3 < 10 ? ("0" + to_string(m3)) : to_string(m3)) << ":" << (s3 < 10 ? ("0" + to_string(s3)) : to_string(s3));
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