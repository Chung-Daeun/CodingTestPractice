#include <iostream>
#include <cstring>

using namespace std;

// 필요 자료형 선언
struct Shark {
    // int r, c; // 상어의 위치
    int s; // 상어의 속력
    int d; // 상어의 이동방향( 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽)
    int z; // 상어의 크기 
};

// 변수 선언
int R, C, M;
Shark sea[105][105];
Shark nxt[105][105];
int fishes = 0;

// 입력
void input() {
    cin >> R >> C >> M;

    int r, c;
    for (int i = 0; i < M; i++) {
        cin >> r >> c;
        // sea[r][c].r = r;
        // sea[r][c].c = c;

        cin >> sea[r][c].s >> sea[r][c].d >> sea[r][c].z;

        // // 속도 간소화
        // if (sea[r][c].d == 1 || sea[r][c].d == 2) {
        //     sea[r][c].s %= 2 * (R - 1);
        // }

        // if (sea[r][c].d == 3 || sea[r][c].d == 4) {
        //     sea[r][c].s %= 2 * (C - 1);
        // }

    }
}

void fishing(int k) {
    for (int i = 1; i <= R; i++) {
        if (sea[i][k].d != 0) {
            // 잡은 상어 무게 추가
            fishes += sea[i][k].z;
            // 잡은 상어 제거
            sea[i][k].d = 0;
            break;
        }
    }
}

bool eatShark(int r, int c, int z) {
    return nxt[r][c].z > z;
}

void moveRow(int r, int c) {
    // 필요변수 추출
    int s = sea[r][c].s;
    int d = sea[r][c].d;
    int z = sea[r][c].z;

    // 이동 횟수 계산
    int move = 0;
    if (R > 1) {
        move = s % (2 * (R - 1));
    }

    // 이동
    while (move--) {
        if (r == 1 && d == 1) d = 2;
        if (r == R && d == 2) d = 1;

        r += (d == 1 ? -1 : 1) * 1;
    }

    // 상어가 있는지 없는지 확인 후 처리
    if (eatShark(r, c, z))  return;

    // 새 위치 잡아주기
    // nxt[r][c].r = r;
    // nxt[r][c].c = c;
    nxt[r][c].s = s;
    nxt[r][c].d = d;
    nxt[r][c].z = z;
}

void moveColumn(int r, int c) {
    // 필요변수 추출
    int s = sea[r][c].s;
    int d = sea[r][c].d;
    int z = sea[r][c].z;

    // 이동 횟수 계산
    int move = 0;
    if (C > 1) {
        move = s % (2 * (C - 1));
    }

    // 이동
    while (move--) {
        if (c == 1 && d == 4) d = 3;
        if (c == C && d == 3) d = 4;

        c += (d == 4 ? -1 : 1) * 1;
    }

    // 상어가 있는지 없는지 확인 후 처리
    if (eatShark(r, c, z))  return;

    // 새 위치 잡아주기
    // nxt[r][c].r = r;
    // nxt[r][c].c = c;
    nxt[r][c].s = s;
    nxt[r][c].d = d;
    nxt[r][c].z = z;
}

void moveSharks() {
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            // 상어발견
            if (sea[i][j].d != 0) {
                // 속력이 0인 경우 연산 생략
                if (sea[i][j].s == 0) {
                    // 상어 크기 비교
                    if (eatShark(i, j, sea[i][j].z))    continue;

                    nxt[i][j] = sea[i][j];
                    continue;
                }
                if (sea[i][j].d == 1 || sea[i][j].d == 2) {
                    moveRow(i, j);
                }
                if (sea[i][j].d == 3 || sea[i][j].d == 4) {
                    moveColumn(i, j);
                }
            }
        }
    }

    // 새 위치로 리뉴얼;
    memcpy(sea, nxt, sizeof(sea));

    // nxt 초기화
    memset(nxt, 0, sizeof(nxt));
}

// 실행
void pro() {
    for (int i = 1; i <= C; i++) {
        // 낚시하기
        fishing(i);

        // 마지막 줄 낚시 후 상어 이동 스킵
        if (i == C) continue;

        // 상어 이동하기
        moveSharks();
    }
}

// 출력
void print() {
    cout << fishes;
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