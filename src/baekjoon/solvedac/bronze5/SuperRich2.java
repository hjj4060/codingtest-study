package baekjoon.solvedac.bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class SuperRich2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n1 = new BigInteger(sc.next());
        BigInteger n2 = new BigInteger(sc.next());

        System.out.println(n1.divide(n2));
        System.out.println(n1.remainder(n2));
    }
}
