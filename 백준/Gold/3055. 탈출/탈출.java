import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static String[] map;

    // 고슴도치 시작점 저장
    static int[] start;
    // 비버굴 저장
    static int[] house;
    // 물 시작점 저장
    static List<int[]> waterList = new ArrayList<>();

    // 물 도착시간
    static int[][] water;
    // 고슴도치 도착시간
    static int[][] animal;

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 크기 정하기
        map = new String[R];
        water = new int[R][C];
        animal = new int[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine();
            for (int c = 0; c < C; c++) {
                switch (map[r].charAt(c)) {
                    // 고슴도치 시작점
                    case 'S':
                        start = new int[]{r, c};
                        break;
                    
                    // 비버굴
                    case 'D':
                        house = new int[]{r, c};
                        // water[r][c] = -2;
                        break;

                    // 물
                    case '*':
                        waterList.add(new int[]{r, c});
                        break;

                    // // 돌
                    // case 'X':
                    //     water[r][c] = -1;
                    //     animal[r][c] = -1;
                    //     break;
                
                    default:
                        break;
                }

            }
        }

        br.close();
    }

    static int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    static void waterBFS() {
        Deque<int[]> bfsQue = new ArrayDeque<>();

        // 시작점 추가
        for (int[] spot: waterList) {
            bfsQue.addLast(spot);
        }

        while (!bfsQue.isEmpty()){
            int[] current = bfsQue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 경계밖은 스킵
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                // 빈칸일 때만 물 범람
                if (map[nr].charAt(nc) == '.') {
                    // 물이 단한번도 온적이 없는 곳만 숫자 업데이트
                    if (water[nr][nc] == 0) {
                        water[nr][nc] = water[current[0]][current[1]] + 1;
                        bfsQue.addLast(new int[]{nr, nc});
                    } 
                }

            }

        }
    }

    static void animalBFS() {
        Deque<int[]> bfsQue = new ArrayDeque<>();

        // 시작점 저장
        bfsQue.addLast(start);

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 경계밖은 스킵
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                // 이미 방문했던 곳도 스킵
                if (animal[nr][nc] != 0)    continue;

                // 빈칸, 또는 비버굴일 때만 이동
                if (map[nr].charAt(nc) == '.' || map[nr].charAt(nc) == 'D') {
                    animal[nr][nc] = animal[current[0]][current[1]] + 1;
                    // 물 범람시기와 비교
                    if (water[nr][nc] != 0 && water[nr][nc] <= animal[nr][nc]) {
                        animal[nr][nc] = -1;
                        continue;
                    }
                    bfsQue.addLast(new int[]{nr, nc});

                }

            }
        }
    }
    public static void main(String[] args) throws Exception{
        input();
        waterBFS();
        animalBFS();
        System.out.println(animal[house[0]][house[1]] == 0 ? "KAKTUS" : animal[house[0]][house[1]]);
        
    }
}