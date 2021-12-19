package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1157
public class WordStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //알파벳 - 개수
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //알파벳
        String s = st.nextToken().toUpperCase(Locale.ROOT);

        for (int i=0; i<s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == null) {
                hashMap.put(s.charAt(i), 1);
            } else {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            }
        }

        for (char c:hashMap.keySet()) {
            System.out.println(c + " " + hashMap.get(c));
        }
        
    }
}
