package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/5585
public class Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int paid_money = Integer.parseInt(st.nextToken());
        int money_arr[] = new int[]{500, 100, 50, 10, 5, 1};

        int change = 1000 - paid_money;

        int count = 0;

        for (int i = 0; i < money_arr.length; i++) {
            count += change / money_arr[i];
            change %= money_arr[i];
        }
        System.out.println(count);
    }
}
