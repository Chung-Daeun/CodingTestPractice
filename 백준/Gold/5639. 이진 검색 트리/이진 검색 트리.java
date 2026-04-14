import java.io.*;
import java.util.*;

class Main {
    static List<Integer> nodeList = new ArrayList<>();
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals("")) break;
            nodeList.add(Integer.parseInt(line));
        }

        br.close();
    }

    static StringBuilder sb = new StringBuilder();
    static void traversal(int left, int right) {
        if (left > right)   return;

        // 분기점 찾기
        int mid = right + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nodeList.get(i) > nodeList.get(left)) {
                mid = i;
                break;
            }
        }

        traversal(left + 1, mid - 1);
        traversal(mid, right);
        sb.append(nodeList.get(left)).append("\n");
    }
    public static void main(String[] args) throws Exception {
        input();
        traversal(0, nodeList.size() - 1);

        System.out.println(sb.toString());
    }
}