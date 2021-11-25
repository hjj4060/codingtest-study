package baekjoon.stepbystep.for_statement;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15552
 * 입력
 * 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다. 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
 *
 * 출력
 * 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
 */
public class FastAplusB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        new FastAplusB().solve(t);
    }
    public void solve(int t) throws IOException {
        while(t>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(a + b + "\n");
            t--;
        }
        bw.close();
    }
}
