package baekjoon.stepbystep.OneDimensionArray;

//https://www.acmicpc.net/problem/2562

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 문제
 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, 서로 다른 9개의 자연수
 *
 * 3, 29, 38, 12, 57, 74, 40, 85, 61
 *
 * 이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
 *
 * 입력
 * 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
 */
public class MaxValue {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i=1; i<=9; i++) {
            hm.put(sc.nextInt(), i);
        }

        new MaxValue().solve(hm);
    }
    public void solve(HashMap<Integer, Integer> hm) {
        int max = 0;

        for (Integer key : hm.keySet()) {
            if(max < key) max = key;
        }
        System.out.println(max);
        System.out.println(hm.get(max));
    }
}
