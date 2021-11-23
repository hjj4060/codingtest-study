package baekjoon.stepbystep.for_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/8393
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        new Sum().solve(sc.nextInt());
    }
    public void solve(int n) {
        int a = 0;

        for(int i=1; i<=n; i++){
            a += i;
        }
        System.out.println(a);
    }
}
