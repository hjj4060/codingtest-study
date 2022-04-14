package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1912 연속합

/*
10  : max = 10

10 - 4 = 6

10 - 4 + 3 = 9

10 - 4 + 3 + 1 = 10

10 - 4 + 3 + 1 + 5 = 15  :  max 15

10 - 4 + 3 + 1 + 5 + 6 = 21 : max 21

10 - 4 + 3 + 1 + 5 + 6 - 35 = -14   -가 되면 다음 인덱스부터 더하기 시작
 */
public class Succession {
    static int seq[];
    static int n;

    public static void main(String[] args) throws IOException {
        input();

        test();


    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        seq = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void test() {
        for (int i = 1; i <= n; i++) {
            System.out.print(seq[i] + " ");
        }
        System.out.println();
    }
}

