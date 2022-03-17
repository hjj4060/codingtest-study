package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2751
public class SortNumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
        }
        //Timsort 방식으로 해야 최악의 case에도 시간복잡도가 O(NlogN)이다.
        Collections.sort(arr);

        //Tim sort 방식으로 해도 시간초과 발생시 StringBuilder 이용해서 출력해야함
        for (Integer i:arr) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
