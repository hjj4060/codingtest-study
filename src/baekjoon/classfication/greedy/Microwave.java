package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Microwave {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[]{300, 60, 10};
        int ans[] = new int[3];

        int T = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i<arr.length; i++) {
            ans[i] = T / arr[i];
            T %= arr[i];
        }

        if(T == 0) {
            for(int i=0; i<ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
