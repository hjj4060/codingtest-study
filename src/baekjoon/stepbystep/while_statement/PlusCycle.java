package baekjoon.stepbystep.while_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1110
public class PlusCycle {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        sc.nextLine();

        int b = 0, sum = 0, result = first, cnt = 0;

        String resultStr;

        if (result >= 100) {
            throw new IllegalAccessException("입력값이 100이상 입니다.");
        }

        do {
            if (result < 10) {
                sum = result;
                b = sum;
            } else if(result >= 10) {
                b = (result % 10);
                sum = (result / 10) + b;
            }

            if(sum>=10) sum = (sum % 10);

            resultStr = b + "" + sum;
            result = Integer.parseInt(resultStr);
            cnt++;
        } while (result != first);

        System.out.println(cnt);
    }
}
