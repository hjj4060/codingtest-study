package baekjoon.stepbystep.OneDimensionArray;

//https://www.acmicpc.net/problem/1546

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 입력
 * 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다.
 * 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
 *
 * 출력
 * 첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
 */
public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> al = new ArrayList<>();

        int N = sc.nextInt();

        for(int i = 0; i<N; i++) {
            al.add(sc.nextDouble());
        }

        new Average().solve(al);
    }

    public void solve(ArrayList<Double> al) {
        double max = 0;
        double sum = 0;

        for (Double i:al) {
            if(i > max) max = i;
        }

        for (Double i:al) {
            sum += i / max * 100;
        }
        System.out.println(sum/al.size());
    }
}
