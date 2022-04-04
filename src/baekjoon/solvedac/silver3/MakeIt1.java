package baekjoon.solvedac.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1463 1로 만들기
public class MakeIt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = 1;
        int result = Integer.parseInt(st.nextToken());
        int step = 0;

        if(result == 1) {
            System.out.println(step);
            return;
        }

        HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
        //map.put(step, new ArrayList<Integer>(Arrays.asList(1))); // 0, 1
        map.put(step, new LinkedHashSet<Integer>());
        map.get(step).add(1);

        Loop:
        while(true) {
            step++;
            map.put(step, new LinkedHashSet<Integer>());

            for (Integer i : map.get(step - 1)) {
                int n1 = i + 1;
                int n2 = i * 2;
                int n3 = i * 3;

                if (n1 == result || n2 == result || n3 == result) {
                    break Loop;
                } else {
                    map.get(step).add(n3);
                    map.get(step).add(n2);
                    map.get(step).add(n1);
                }
            }

            //test
            System.out.print(step + ": ");
            for (Integer i : map.get(step)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println(step);
    }
}
