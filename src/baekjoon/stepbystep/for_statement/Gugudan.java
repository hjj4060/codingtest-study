package baekjoon.stepbystep.for_statement;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2739
public class Gugudan {
    public static void main(String[] args) {
        new Gugudan().solve(new Scanner(System.in).nextInt());
    }
    public void solve(int num) {
        for(int i=1; i<10; i++) {
            System.out.println(num + " * " + i + " = " + num*i);
        }
    }
}
