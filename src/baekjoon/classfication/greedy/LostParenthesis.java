package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1541
public class LostParenthesis {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String S;
    static String str[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        S = st.nextToken();
        str = S.split("-");

        //test();

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            int temp = 0;

            String addtion[] = str[i].split("\\+");
            //test(addtion);

            for (int j = 0; j < addtion.length; j++) {
                temp += Integer.parseInt(addtion[j]);
            }
            //System.out.println(temp);

            if (result == Integer.MAX_VALUE) {
                result = temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }

    private static void test() {
        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);
        }

        System.out.println(Integer.MAX_VALUE);
    }

    private static void test(String[] str) {
        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
