package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11034
public class ThreeKangaroos2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A, B, C;
        String line;
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            try {
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                System.out.println(Math.max(B - A, C - B) - 1);
            } catch (Exception e) {
                break;
            }
        }
    }
}

