#include <iostream>
#include <algorithm>

using namespace std;

#define NM 100005

// 입력받을 자료형 선언
struct Elem{
    string name;
    int korean, eng, math;
    bool operator<(const Elem &rhs) const {
        if (korean != rhs.korean) return rhs.korean < korean;
        if (eng != rhs.eng) return eng < rhs.eng;
        if (math != rhs.math) return rhs.math < math;
        return name < rhs.name;
    }
}a[NM];

// 변수 선언
int N;

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a[i].name >> a[i].korean >> a[i].eng >> a[i].math;
    }
}

void pro() {
    sort(a, a + N);
    for (int i = 0; i < N; i++) {
        cout << a[i].name << "\n"; 
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

    return 0;
}