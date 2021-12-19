package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10809
public class FindAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int result[] = new int[26];

        String S = st.nextToken();

        for(int i=0; i<result.length; i++){
            result[i] = -1;
        }

        for(int i=0; i<alphabet.length(); i++) {
            int index = -1;

            for(int j=0; j<S.length(); j++) {
                if (alphabet.charAt(i) == S.charAt(j)) {
                    index = j;
                    break;
                }
            }
            result[i] = index;
        }
        for (int i:result) {
            System.out.print(i + " ");
        }
    }
}
