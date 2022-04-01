package baekjoon.solvedac.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1463 1로 만들기
public class MakeIt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = 1;
        int result = Integer.parseInt(st.nextToken());
        int step = 0;

        ArrayList<Integer> list = new ArrayList<>();

        if(result == 1) {
            System.out.println(step);
            return;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(step, new ArrayList<>(1));

        Loop:
        while(true) {
            step++;

            for (Integer i : map.get(step - 1)) {
                int n1 = i + 1;
                int n2 = i * 2;
                int n3 = i * 3;

                if (n1 == result || n2 == result || n3 == result) {
                    break Loop;
                } else {
                    map.put(step, new ArrayList<>(n1));
                    map.put(step, new ArrayList<>(n2));
                    map.put(step, new ArrayList<>(n3));
                }
            }
        }

        System.out.println(step);
    }
}
