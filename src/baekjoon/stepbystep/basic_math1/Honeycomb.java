package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //58
        int n = sc.nextInt();

        int base = 6, i = 1, cnt = 1;

        while(true) {
            if (n <= i) {
                break;
            }
            i += base;
            base = base + 6;

            cnt++;
        }

        System.out.println(cnt);
    }
}
