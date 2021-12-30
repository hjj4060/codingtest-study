package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10250
public class ACMHotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); //테스트케이스
        int H = 0, W = 0, N = 0;
        int hotel[] = null;


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //층수
            W = Integer.parseInt(st.nextToken()); //방수
            N = Integer.parseInt(st.nextToken()); //몇번째 손님

            hotel = new int[H*W+1]; //호텔방

            int index = 1;

            for (int k = 0; k < W; k++) {
                for (int j = 101; j <= H * 101; j = j + 100) {
                    hotel[index] = j+k;
                    index++;
                }
            }
            System.out.println(hotel[N]);
        }
    }
}
