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

        int left = 0;
        int right = 0;
        int minLength = N + 1;

        while(left <= right && right <= N) {
            int subtotal = 0;

            if(left != right) {
                for(int i=left; i<=right; i++) {
                    subtotal += arr[i];
                }
            } else {
                subtotal += arr[left];
            }

            int length = right - left + 1;

            if (subtotal == S) {
                if(length == 1) {
                    minLength = length;
                    break;
                } else {
                    minLength = Math.min(minLength, length);
                    left++;
                }
            } else if (subtotal < S){
                right++;
            } else if (subtotal > S) {
                left++;
            }
        }

        if(minLength != N + 1) {
            System.out.println(minLength);
        } else {
            System.out.println(0);
        }
    }
}
