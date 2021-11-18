package baekjoon.stepbystep.io_and_arithmetic;

import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/2588
 */
public class Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        new Multiplication().solve(num1, num2);
    }

    void solve(int num1, int num2) {
        int a=0, b=0, c=0;

        a = num2 / 100;
        b = num2 / 10 % 10;
        c = num2 % 10;

        System.out.println(num1*c);
        System.out.println(num1*b);
        System.out.println(num1*a);
        System.out.println(num1*num2);
    }
}
