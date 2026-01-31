import java.io.*;
import java.util.*;

public class Main {
    static class Elem implements Comparable<Elem>{
        String name;
        int kor;
        int eng;
        int math;

        @Override
        public int compareTo(Elem other) {
            if (kor != other.kor)   return other.kor - kor;
            if (eng != other.eng)   return eng - other.eng;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
        
    }

    static int N;
    static List<Elem> students = new ArrayList<>();

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            students.add(new Elem());
            st = new StringTokenizer(br.readLine());

            students.get(i).name = st.nextToken();
            students.get(i).kor = Integer.parseInt(st.nextToken());
            students.get(i).eng = Integer.parseInt(st.nextToken());
            students.get(i).math = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
    public static void main(String[] args) throws Exception{
        input();
        Collections.sort(students);
        for (int i = 0; i < N; i++) {
            System.out.println(students.get(i).name);
        }   
    }
}