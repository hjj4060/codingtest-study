package baekjoon.stepbystep.for_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10950
public class APlusBMinus3 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new APlusBMinus3().solve(sc.nextInt());
    }

    public void solve(int num) {
        while(num>0) {

            System.out.println(sc.nextInt() + sc.nextInt());
            num--;
        }
    }
}
