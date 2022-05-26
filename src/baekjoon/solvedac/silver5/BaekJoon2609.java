package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2609 최대공약수와 최소공배수
/*
    유클리드 호제법 알고리즘
    1. 매개변수로 a,b를 받는다 (단 a>b)
    2. b가 0이라면, a가 최대 공약수
    3. b가 0이 아니라면, 1번의 매개변수에 b와 a & b를 전달한다.
    4. 위 내용을 전달한다
 */
public class BaekJoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r = euclidGCD(a, b);
        System.out.println(r);
        System.out.println((a * b) / r);

    }

    /*
        90%24 = 18
        24%18 = 6
        18%6 = 0
        6%0 -> b값이 0일때 a리턴
     */
    private static int euclidGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return euclidGCD(b, a % b);
    }
}
