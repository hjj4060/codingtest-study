package baekjoon.stepbystep.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/4673
public class SelfNumber {
    static int a[];

    private static int max = 10000;

    public static void main(String[] args) throws IOException {
        a = new int[max+1];

        //1부터 10까지 체크
        for (int i = 1; i <= max; i++) {
            new SelfNumber().check(i);
        }

        for(int i=1; i<max; i++) {
            if(a[i] == 0) System.out.println(i);
        }
    }

    public void check(int c) {
        if(a[c] == 1) return;

        int n1, n10, n100, n1000;

        //숫자 3으로 쭉 100보다 작은수찾기
        while(c < max) {
            if (c >= 1000) {
                n1 = (c % 1000 % 100 % 10) / 1;
                n10 = (c % 1000 % 100) / 10;
                n100 = (c % 1000) / 100;
                n1000 = c / 1000;

                c = c + n1000 + n100 +n10 + n1;
            } else if (c >= 100) {
                n100 = c / 100;
                n10 = (c % 100) / 10;
                n1 = (c % 100) % 10;

                c = c + n100 +n10 + n1;
            } else  {
                n10 = c / 10;
                n1 = c % 10;

                c = c + n10 + n1;
            }

            if (c < max ) {
                if(a[c] == 0){ a[c] = 1;}
            }
        }
    }
}
