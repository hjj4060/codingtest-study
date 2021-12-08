package baekjoon.stepbystep.OneDimensionArray;

//https://www.acmicpc.net/problem/8958

import java.util.ArrayList;
import java.util.Scanner;

public class OXQuiz {
    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        sc.nextLine();

        new OXQuiz().solve(N);
    }
    public void solve(int N) {
        ArrayList<String> al = new ArrayList<>();
        int score = 0, tmp = 0;

        for(int i=0; i<N; i++) {
            al.add(sc.nextLine());
        }

        for (String s:al) {
            for (char c:s.toCharArray()) {
                if(c=='O') {
                    tmp++;
                    score += tmp;
                } else {
                    tmp = 0;
                }
            }
            System.out.println(score);
            tmp = 0;
            score = 0;
        }
    }
}
