package baekjoon.classfication.greedy;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2720
public class DonghyukLaundry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[]{25, 10, 5, 1};

        int T = Integer.parseInt(st.nextToken());
        int C;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());

            for (int j = 0; j < arr.length; j++) {
                sb.append(C / arr[j] + " ");
                C %= arr[j];
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
