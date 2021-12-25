package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int bunja = 1, bunmo = 1;
        int t = 1;
        int diagonal = 0;
        int cnt = 1;

        Loop1:
        while (true) {
            t++;
            diagonal++;

            if (t % 2 == 0) {
                for (int j = 1; j <= diagonal; j++) {
                    bunja = t - j;
                    bunmo = j;
                    if (x != cnt) {
                        cnt++;
                    } else {
                        break Loop1;
                    }
                }
            } else {
                for (int j = 1; j <= diagonal; j++) {
                    bunja = j;
                    bunmo = t - j;
                    if (x != cnt) {
                        cnt++;
                    } else {
                        break Loop1;
                    }
                }
            }
        }
        System.out.println(bunja + "/" + bunmo);
    }
}
