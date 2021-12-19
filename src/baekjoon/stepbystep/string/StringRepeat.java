package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2675
public class StringRepeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //테스트케이스 개수
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            //반복 횟수
            int R = Integer.parseInt(st.nextToken());

            //반복할 문자열
            String S = st.nextToken();
            for (char c:S.toCharArray()) {
                for(int j=0; j<R; j++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
