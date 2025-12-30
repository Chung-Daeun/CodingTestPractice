import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 필요변수
    static int N, M, K;    // N: 밭의 크기, M: 나무의 수, K: 년도
    static int[][] A = new int[15][15];    //  추가되는 비료
    static Cell[][] field = new Cell[15][15];   // 밭(양분+나무)

    // main
    public static void main(String[] args) throws Exception{
        input();
        pro();
        print();
    }

    // 입력
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 간단 변수 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 비료 양 입력 + Cell 선언
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
                field[r][c] = new Cell();
            }
        }

        // 나무 입력
        // 리스트에 임시로 담기
        List<int[]> treeList = new ArrayList<int[]>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            treeList.add(new int[3]);
            treeList.get(i)[0] = Integer.parseInt(st.nextToken());
            treeList.get(i)[1] = Integer.parseInt(st.nextToken());
            treeList.get(i)[2] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Collections.sort(treeList, (a, b) -> a[2] - b[2]);

        // deque에 옮기기
        for (int i = 0; i < M; i++) {
            field[treeList.get(i)[0]][treeList.get(i)[1]].trees.addLast(treeList.get(i)[2]);
        }

        // 리스트 삭제
        treeList = null;

        br.close();
    }

    // 실행
    private static void pro() {
        while (K-- > 0) {
            eatFoodAndDead();
            birthTree();
        }
    }

    // 봄+여름+겨울
    private static void eatFoodAndDead() {
        // 한칸씩 실행
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                // 나무가 있으면
                if (!field[r][c].trees.isEmpty()) {
                    // 양분을 먹은 나무
                    Deque<Integer> liveTrees = new ArrayDeque<>();

                    // 죽은 나무가 양분이 되는 양
                    int deadTrees = 0;

                    for (int tree : field[r][c].trees) {
                        if (field[r][c].nri >= tree) {  // 양분을 먹는 경우
                            field[r][c].feedTree(tree);
                            liveTrees.addLast(++tree);
                        } else {    // 양분을 못 먹는 경우
                            deadTrees += tree / 2;
                        }
                    }

                    // 새나무 조합으로 교체
                    field[r][c].changeTrees(liveTrees);

                    // 죽은나무 양분으로 추가
                    field[r][c].addNri(deadTrees);
                }

                // 겨울 양분 추가
                field[r][c].addNri(A[r][c]);
            }
        }
    }

    // 가을
    private static void birthTree() {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                // 나무 없으면 스킵
                if (field[r][c].trees.isEmpty())    continue;

                for (int tree : field[r][c].trees) {
                    // 나이가 5의 배수면 번식
                    if (tree % 5 == 0) {
                        int nr, nc;
                        for (int i = 0; i < 8; i++) {
                            nr = r + dr[i];
                            nc = c + dc[i]; 

                            // 밭 밖에는 나무가 나지 않는다
                            if (nr < 1 || nr > N || nc < 1 || nc > N)   continue;

                            field[nr][nc].newTree();
                        }
                    }
                }
            }
        }
    }
    
    // 출력
    private static void print() throws IOException {
        int cnt = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                cnt += field[r][c].trees.size();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    // nest class
    private static class Cell {
        private int nri = 5;
        private Deque<Integer> trees = new ArrayDeque<>();


        void addNri(int num) {
            this.nri += num;
        }

        void newTree() {
            this.trees.addFirst(1);
        }

        void feedTree(int num) {
            this.nri -= num;
        }

        void changeTrees(Deque<Integer> newTrees) {
            this.trees = newTrees;
        }

    }
}