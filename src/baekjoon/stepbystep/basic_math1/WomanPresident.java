package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WomanPresident {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //Test Case
        int T = Integer.parseInt(st.nextToken());
        int K = 0, N = 0;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken()); //K층
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //N호

            //층은 0부터 호는 1호부터
            int apart[][] = new int[K+1][N+1];
            
            //층만들기
            for (int j = 0; j <= K; j++) {
                for (int l = 1; l<= N; l++) {
                    //호실
                    if (j == 0) {
                        apart[j][l] = l;
                    } else {
                        //아래층 호실 +
                        int cnt = 0;
                        for (int z = 1; z <= l; z++) {
                            cnt += apart[j-1][z];
                        }
                        apart[j][l] = cnt;
                    }
                }
            }
            System.out.println(apart[K][N]);
        }
    }
}
