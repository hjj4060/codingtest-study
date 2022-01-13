package baekjoon.classfication.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1806
public class SubTotal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열개수
        int S = Integer.parseInt(st.nextToken()); //부분합

        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 0;
        int minLength = N + 1; //11
        int subtotal = 0;

        for(int i=left; i<=N; i++) {
            while(right < N && subtotal < S) {
                right++;
                subtotal += arr[right];
            }

            if (subtotal >= S) {
                minLength = Math.min(minLength, right - i + 1);
            }

            subtotal -= arr[i];
        }

        if(minLength != N + 1) {
            System.out.println(minLength);
        } else {
            System.out.println(0);
        }
    }
}
