package baekjoon.stepbystep.if_statement;

import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/1330

    두 수 A,B 를 입력하면 첫째 줄에 다음 세 가지 중 하나를 출력한다.
    - A가 B보다 큰 경우에는 '>'를 출력한다.
    - A가 B보다 작은 경우에는 '<'를 출력한다.
    - A와 B가 같은 경우에는 '=='를 출력한다.
 */
public class CompareTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        new CompareTwoNumbers().solve(num1, num2);
    }

    public void solve(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(">");
        } else if (num1 < num2) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}