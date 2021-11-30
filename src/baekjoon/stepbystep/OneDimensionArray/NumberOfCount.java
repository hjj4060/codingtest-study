package baekjoon.stepbystep.OneDimensionArray;

//https://www.acmicpc.net/problem/2577

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 *
 * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 *
 * 입력
 * 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
 *
 * 출력
 * 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 */
public class NumberOfCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt() * sc.nextInt() * sc.nextInt();

        new NumberOfCount().solve(n);
    }
    public void solve(int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        String nStr = n + "";

        for (int i = 0; i < 10; i++) {
            al.add(0);
        }

        for (char ch:nStr.toCharArray()) {
            int num = ch - '0';

            switch (num) {
                case 0: al.set(0, al.get(0)+1);
                        break;
                case 1: al.set(1, al.get(1)+1);
                        break;
                case 2: al.set(2, al.get(2)+1);
                        break;
                case 3: al.set(3, al.get(3)+1);
                        break;
                case 4: al.set(4, al.get(4)+1);
                        break;
                case 5: al.set(5, al.get(5)+1);
                        break;
                case 6: al.set(6, al.get(6)+1);
                        break;
                case 7: al.set(7, al.get(7)+1);
                        break;
                case 8: al.set(8, al.get(8)+1);
                        break;
                case 9: al.set(9, al.get(9)+1);
                        break;
            }

        }
        for (int i: al) {
            System.out.println(i);
        }
    }
}
