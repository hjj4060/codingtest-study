package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2920
public class Scale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n[] = new int[9];

        for(int i=1; i<n.length; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        Boolean ascending = true;
        for(int i=1; i<n.length; i++) {
            if(n[i] != i) {
                ascending = false;
                break;
            }
        }

        if(ascending == true) {
            System.out.println("ascending");
            return;
        }

        Boolean descending = true;
        for(int i=1; i<n.length; i++) {
            if(n[i] != n.length - i) {
                descending = false;
            }
        }

        if(descending == true) {
            System.out.println("descending");
            return;
        } else {
            System.out.println("mixed");
        }
    }
}
