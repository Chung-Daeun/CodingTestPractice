package tree;

import java.io.*;
import java.util.*;

public class Main {
    static List<Tree> treeList = new LinkedList<>();
    static List<Tree> trashList = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력값 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int tree_num = Integer.parseInt(st.nextToken());
    int year = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    for(int i = 0; i < n; i++){
    	st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++){
            a[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    for(int i = 0; i < tree_num; i++){
    	st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int age = Integer.parseInt(st.nextToken());
        treeList.add(new Tree(r, c, age));
    }

    // 밭생성
    int[][] field = new int[n][n];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            field[i][j] = 5;
        }
    }

    // 시간 흐름
    for(int i = 0 ; i < year; i++){
        // 봄
        field = Tree.spring(field);
        // 여름
        field = Tree.summer(field);
        // 가을
        Tree.fall(n);
        // 정렬
        treeList.sort((o1, o2) -> o1.year - o2.year);
        // 겨울
        field = Tree.winter(field, a);
    }

    bw.write(treeList.size() + "\n");
    bw.flush();
    bw.close();
    
    }
    public static class Tree{

        int r;
        int c;
        int year;

        public Tree(int r, int c, int year){
            this.r = r - 1;
            this.c = c - 1;
            this.year = year;
        }

        public void setTreeYear(int year){
            this.year = year;
        }

        public static int[][] spring(int[][] field){
            for (int i = 0; i < treeList.size(); i++) {
                int x = treeList.get(i).r;
                int y = treeList.get(i).c;
                int scr = treeList.get(i).year;

                if(field[x][y] < scr){
                    trashList.add(treeList.get(i));
                    treeList.remove(i);
                    i--;
                } else {
                    field[x][y] -= scr;
                    treeList.get(i).setTreeYear(scr + 1);
                }
            }
            return field;
        }

        public static int[][] summer(int[][] field){
            for(Tree tree : trashList){
                int x = tree.r;
                int y = tree.c;
                int scr = tree.year;

                field[x][y] += scr / 2;
            }
            trashList.clear();
            return field;
        }

        public static void fall(int n){
        	int len = treeList.size();
            for(int i = 0; i < len; i++){
                if(treeList.get(i).year % 5 == 0){
                    if(treeList.get(i).r - 1 >= 0){
                        if(treeList.get(i).c - 1 >= 0){
                            treeList.add(new Tree(treeList.get(i).r, treeList.get(i).c, 1));
                        }
                        treeList.add(new Tree(treeList.get(i).r, treeList.get(i).c + 1, 1));
                        if(treeList.get(i).c + 1 < n){
                            treeList.add(new Tree(treeList.get(i).r, treeList.get(i).c + 2, 1));
                        }
                    }
                    if(treeList.get(i).c - 1 >= 0){
                        treeList.add(new Tree(treeList.get(i).r + 1, treeList.get(i).c, 1));
                    }
                    if(treeList.get(i).c + 1 < n){
                        treeList.add(new Tree(treeList.get(i).r + 1, treeList.get(i).c + 2, 1));
                    }
                    if(treeList.get(i).r + 1 < n){
                        if(treeList.get(i).c - 1 >= 0){
                            treeList.add(new Tree(treeList.get(i).r + 2, treeList.get(i).c, 1));
                        }
                        treeList.add(new Tree(treeList.get(i).r + 2, treeList.get(i).c + 1, 1));
                        if(treeList.get(i).c + 1 < n){
                            treeList.add(new Tree(treeList.get(i).r + 2, treeList.get(i).c + 2, 1));
                        }
                    }
                }
            }
        }

        public static int[][] winter(int[][] field, int[][] arr){
            for(int i = 0; i < field.length; i++){
                for(int j = 0; j < field[i].length; j++){
                    field[i][j] += arr[i][j];
                }
            }
            return field;
        }

        @Override
        public String toString() {
            return "Tree{" + r + ", " + c + ", " + year + '}';
        }
    }
}
