package baekjoon.stepbystep.for_statement;

//https://www.acmicpc.net/problem/10871

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제
 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
 *
 * 둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
 *
 * 출력
 * X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 */
public class NumberLessThanX {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int N = sc.nextInt();
        int X = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }

        new NumberLessThanX().solve(arrayList, X);
    }
    public void solve(ArrayList<Integer> arrayList, int X) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = br.readLine();
        //StringTokenizer st = new StringTokenizer(s);

        ArrayList<Integer> al = new ArrayList<Integer>();

        /*for (int i = 0; i < arrayList.size(); i++) {
            if(st.hasMoreElements()) {
                int n = Integer.parseInt(st.nextToken());
                if(n<X) al.add(n);
            } else break;
        }*/

        for (Integer i : arrayList) {
            //System.out.print(i + " ");
            if(i < X)
                al.add(i);
        }

        for (Integer i : al) {
            System.out.print(i + " ");
        }
    }
}
