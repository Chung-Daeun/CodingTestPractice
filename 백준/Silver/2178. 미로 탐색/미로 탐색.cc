#include <iostream>
#include <deque>

using namespace std;
struct Node {
    int row, col, path;
};

// 필요변수
int N, M;
int maze[100][100];
int minBlock = 0;
int visited[100][100];
deque<Node> bfsQue;

// 입력
void input() {
    cin >> N >> M;
    string line;

    for (int i = 0; i < N; i++) {
        cin >> line;
        for (int j = 0; j < line.length(); j++) {
            maze[i][j] = line[j] - '0';
            visited[i][j] = 0;
        }
    }
}

void pro() {
    // 시작
    bfsQue.push_back({0, 0, 1});

    // 이동 편의용 배열
    int vr[] = {-1, 1, 0, 0};
    int vc[] = {0, 0, -1, 1};

    // 큐가 비기 전까지 반복
    while (!bfsQue.empty()) {
        // 방문할 노드 빼기
        Node nowNode = bfsQue.front();
        bfsQue.pop_front();

        // 도착지라면 멈춤
        if (nowNode.row == N -1 && nowNode.col == M - 1) {
            minBlock = nowNode.path;
            break;
        }

        // 방문 체크
        if (visited[nowNode.row][nowNode.col]) continue;
        visited[nowNode.row][nowNode.col] = 1;

        // 상하좌우 중 갈 수 있는 곳 큐에 넣기
        for (int i = 0; i < 4; i++) {
            int nr = nowNode.row + vr[i];
            int nc = nowNode.col + vc[i];

            // 미로 밖이면 탈락
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            // 이미 방문한 적 있는 곳이면 스킵
            if (visited[nr][nc]) continue;

            // 막힌 곳이면 스킵
            if (maze[nr][nc] == 0)  continue;

            // 조건 충족하면 큐에 집어넣기
            bfsQue.push_back({nr, nc, nowNode.path + 1});
        }
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
    cout << minBlock;
}