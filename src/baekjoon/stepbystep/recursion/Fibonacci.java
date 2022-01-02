package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Fibonacci {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arrayList.add(0);
        arrayList.add(1);

        new Fibonacci().recur(2);

        System.out.println(arrayList.get(n));
    }

    public void recur(int c) {
        arrayList.add(arrayList.get(c - 1) + arrayList.get(c - 2));

        if (c <= 20) {
            recur(c + 1);
        }

        return;
    }
}
