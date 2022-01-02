package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StarPrint {
    static double empty = 0;
    static int jump = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int forcnt = N * N;
        empty = Math.ceil((double)forcnt / 2);
        jump = N;

        new StarPrint().recur(forcnt);
    }

    private void recur(int num) {
        // (N/2) 올림번째 별 안찍음
        if (empty == (double) cnt) {
            return;
        }
        cnt++;
        System.out.print("*");

        if(cnt == jump) {
            jump = jump * 2;
            System.out.println();
        }

        cnt++;

        //N*N 만큼 recur
        if (cnt <= num) {
            recur(num);
        }

        return;
    }
}
