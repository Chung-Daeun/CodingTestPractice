#include <iostream>
#include <vector>

using namespace std;

// 변수선언
int N, M;
vector<int> v(10001, 0);
vector<int> ans(8,0);

// 입력
void input() {
    cin >> N >> M;
    int temp;

    for (int i = 0; i < N; i++) {
        cin >> temp;
        v[temp]++;
    }
}

void func(int k) {
    if (k == M) {
        // 선택완료
        // 출력
        for (int i = 0; i < M; i++) {
            cout << ans[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int cand = 1; cand <= 10000; cand++) {
        // 수가 없을 경우 다음 수를 찾으러 감.
        if (v[cand] == 0) {
            continue;
        }

        // 수를 찾았으면 정답 벡터에 추가
        ans[k] = cand;
        // 해당 수 갯수 줄이기
        v[cand]--;

        // 다음 자리 찾기
        func(k + 1);

        // 추가한 숫자 지우기
        ans[k] = 0;
        // 수 갯수 원상복구
        v[cand]++;
    }
}


int main() {
    // 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력 + 연산 + 출력
    input();
    func(0);
    
    return 0;
}