package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11053 가장 긴 증가하는 부분 수열
public class LongestIncreasingSubsequence {
    int A[];


    public static void main(String[] args) {
        input();


    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
