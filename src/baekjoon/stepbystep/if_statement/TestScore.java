package baekjoon.stepbystep.if_statement;

import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/9498

    문제
    시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 */
public class TestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testScore = scanner.nextInt();

        new TestScore().solve(testScore);
    }

    public void solve(int testScore) {
        switch(testScore/10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}
