package baekjoon.stepbystep.for_statement;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2438
 * https://www.acmicpc.net/problem/2439
 */
public class StarPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        /*for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        for (int i = 0; i < a; i++) {
            for (int k = 1; k < a - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
