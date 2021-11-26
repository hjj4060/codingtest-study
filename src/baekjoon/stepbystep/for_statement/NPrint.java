package baekjoon.stepbystep.for_statement;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2741
 * https://www.acmicpc.net/problem/2742
 * 문제
 * 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
 *
 * 출력
 * 첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
 */
public class NPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
        */
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }
    }
}