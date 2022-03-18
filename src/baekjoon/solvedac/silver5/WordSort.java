package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1181 단어 정렬
public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(st.nextToken());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } {
                    int n1 = 0, n2 = 0;

                    for (char c : o1.toCharArray()) {
                        n1 += c;
                    }

                    for (char c : o2.toCharArray()) {
                        n2 += c;
                    }

                    return n1 - n2;
                }
            }
        });

        for (String s:list) {
            System.out.println(s);
        }
    }
}
