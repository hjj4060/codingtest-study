package baekjoon.stepbystep.while_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1110
public class PlusCycle {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = 0, sum = 0;

        if (a < 10) {
            sum = a;
        } else if (a >= 10) {
            b = (a % 10);
            sum = (a / 10) + b;
        } else {
            throw new IllegalAccessException("입력값이 100이상 입니다.");
        }



        do {

        } while (a != sum);
    }
}
