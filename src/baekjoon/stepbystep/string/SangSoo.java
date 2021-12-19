package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2908
public class SangSoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(st.nextToken() + " " + st.nextToken());
        String s = sb.reverse().toString();
        String ss[] = s.split(" ");

        int max = Integer.parseInt(ss[0]);

        if(max < Integer.parseInt(ss[1])) {
            max = Integer.parseInt(ss[1]);
        }
        System.out.println(max);
    }
}
