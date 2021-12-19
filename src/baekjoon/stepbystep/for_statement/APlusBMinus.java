package baekjoon.stepbystep.for_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10950
//https://www.acmicpc.net/problem/11021
//https://www.acmicpc.net/problem/11022
public class APlusBMinus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new APlusBMinus().solve(Integer.parseInt(br.readLine()));
    }

    public void solve(int num) throws IOException {
        for (int i=1; i <= num  ; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a + b;

            //sb.append("Case #" + i + ": " + c + "\n");
            sb.append("Case #" + i + ": " + a + " + " + b + " = " + c + "\n");
        }

        System.out.println(sb.toString());
    }
}
