package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2869
public class SnailWantsToClimb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int min_distance  = v - a;
        int one_day = a - b;

        int cnt = (min_distance / one_day) + 1;

        if(min_distance % one_day != 0) cnt++;

        System.out.println(cnt);
    }
}
