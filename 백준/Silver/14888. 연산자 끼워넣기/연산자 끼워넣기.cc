#include <iostream>
#include <vector>
#include <limits>

using namespace std;

int N;
vector<int> numV;
vector<int> oper(4, 0);
int minAns = numeric_limits<int>::max();
int maxAns = numeric_limits<int>::min();

// 입력
void input() {
    // 숫자 갯수 받기
    cin >> N;

    int temp;
    // 숫자 벡터 채우기
    for (int i = 0; i < N; i++) {
        cin >> temp;
        numV.push_back(temp);
    }
    // 연산자 벡터 채우기
    for (int i = 0; i < 4; i++) {
        cin >> oper[i];
    }
}

int sum(int a, int b) {
    return a + numV[b];
}

int sub(int a, int b) {
    return a - numV[b];
}

int mul(int a, int b) {
    return a * numV[b];
}

int di(int a, int b) {
    if (a < 0) {
        return (-1) * ((-1 * a) / numV[b]);
    }

    return a / numV[b];
}

void rec_func(int k, int ans) {
    // 연산완료
    if (k == N) {
        if (minAns > ans) {
            minAns = ans;
        }

        if (maxAns < ans) {
            maxAns = ans;
        }

        return;
    }

    // 연산
    for (int i = 0; i < 4; i++) {
        if (oper[i] == 0) {
            continue;
        }

        // 연산 후 다음단계 이동
        oper[i]--;
        switch(i) {
            case 0:
                rec_func(k + 1, sum(ans, k));
                break;
            case 1:
                rec_func(k + 1, sub(ans, k));
                break;
            case 2:
                rec_func(k + 1, mul(ans, k));
                break;
            case 3:
                rec_func(k + 1, di(ans, k));
                break;
        }

        // 연산자 변경
        oper[i]++;
        continue;
    }

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    input();
    rec_func(1, numV[0]);

    // 결과 출력
    cout << maxAns << "\n" << minAns;
    return 0;
}