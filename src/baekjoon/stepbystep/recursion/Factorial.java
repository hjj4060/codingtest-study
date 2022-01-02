package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10872
public class Factorial {
    static int sum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        new Factorial().recur(N);
        System.out.println(sum);
    }

    public void recur(int num) {
        if(num == 0) return;

        sum *= num;

        if(num > 1) {
            recur(num - 1);
        }

        return;
    }
}
