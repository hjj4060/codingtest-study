package baekjoon.stepbystep.while_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10952
//https://www.acmicpc.net/problem/10951
public class APlusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;

       /* do {
            a = sc.nextInt();
            b = sc.nextInt();

            if(a != 0 && b != 0) System.out.println(a+b);
        } while (a != 0 && b != 0);*/
        while(sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a+b);
        }
    }
}
