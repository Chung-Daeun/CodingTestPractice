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

// 계산 함수
int calc(int operand1, int oper, int operand2) {
    switch(oper) {
        case 0:
            return operand1 + operand2;
        case 1:
            return operand1 - operand2;
        case 2:
            return operand1 * operand2;
        case 3:
            if (operand1 < 0) {
                return -1 * ((-1 * operand1) / operand2);
            }
            return operand1 / operand2;
    }
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
        rec_func(k + 1, calc(ans, i, numV[k]));

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