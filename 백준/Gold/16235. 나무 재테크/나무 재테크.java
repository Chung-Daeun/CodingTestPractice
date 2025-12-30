import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 필요변수
    static int N, M, K;    // N: 밭의 크기, M: 나무의 수, K: 년도
    static int[][] A = new int[15][15];    //  추가되는 비료
    static Deque<Tree>[][] trees = new Deque[15][15];  // 나무
    static int[][] field = new int[15][15];

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

        // 비료 양 입력 + 초기 비료 양 저장 + deque선언
        for (int r = 1; r <= N; r++) {
            Arrays.fill(field[r], 5);
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
                // trees[r][c] = new ArrayDeque<>();
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

        // 나무 deque 초기화
        for (int r = 0; r <= N+1; r++) {
            for (int c = 0; c <= N+1; c++) {
                trees[r][c] = new ArrayDeque<>();
            }
        }

        // deque에 옮기기
        for (int i = 0; i < M; i++) {
            trees[treeList.get(i)[0]][treeList.get(i)[1]].addLast(new Tree(treeList.get(i)[2]));
        }

        // 리스트 삭제
        treeList = null;

        br.close();
    }

    // 실행
    private static void pro() {
        while (K-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
    }

    // 봄
    private static void spring() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                // 비었으면 넘어가기
                if (trees[r][c].isEmpty())  continue;

                for (Tree tree: trees[r][c]) {
                    // 양분 부족
                    if (field[r][c] < tree.age) {
                        tree.noFood();
                        continue;
                    }
                    // 양분 섭취
                    field[r][c] -= tree.age;
                    tree.eatFood();
                    tree.growTree();
                }
            }
        }
    }
    // 여름
    private static void summer() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                while (!trees[r][c].isEmpty() && !trees[r][c].peekLast().isEat) {
                    field[r][c] += trees[r][c].pollLast().age / 2;
                }
            }
        }
    }
    // 가을
    private static void fall() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                // 비었으면 스킵
                if (trees[r][c].isEmpty())  continue;

                for (Tree tree : trees[r][c]) {
                    if (tree.age % 5 == 0) {
                        trees[r - 1][c - 1].addFirst(new Tree(1));
                        trees[r - 1][c].addFirst(new Tree(1));
                        trees[r - 1][c + 1].addFirst(new Tree(1));
                        trees[r][c - 1].addFirst(new Tree(1));
                        trees[r][c + 1].addFirst(new Tree(1));
                        trees[r + 1][c - 1].addFirst(new Tree(1));
                        trees[r + 1][c].addFirst(new Tree(1));
                        trees[r + 1][c + 1].addFirst(new Tree(1));
                    }
                }
            }
        }
    }
    // 겨울
    private static void winter() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                field[r][c] += A[r][c];
            }
        }
    }

    // 출력
    private static void print() throws IOException {
        int cnt = 0;

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                cnt += trees[r][c].size();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    // nest class
    private static class Tree {
        private int age;
        private boolean isEat;

        // 생성자
        Tree(int age) {
            this.age = age;
        }

        // 나무 나이 먹음
        void growTree() {
            this.age++;
        }

        // 나무 비료 먹음
        void eatFood() {
            this.isEat = true;
        }

        // 비료 부족
        void noFood() {
            this.isEat = false;
        }
    }
}