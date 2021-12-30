package baekjoon.stepbystep.basic_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigNumberAplusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n1, n2, sum, carry = 0;

        //문자열로 숫자 더하기
        String a = st.nextToken();
        String b = st.nextToken();

        //인데스
        int aleng = a.length()-1;
        int bleng = b.length()-1;

        while(aleng >= 0 || bleng >= 0) {
            n1 = 0;
            n2 = 0;

            if (aleng >= 0) {
                n1 = a.charAt(aleng) - '0';
                aleng--;
            }

            if (bleng >= 0) {
                n2 = b.charAt(bleng) - '0';
                bleng--;
            }

            sum = n1 + n2 + carry;
            carry = sum / 10;

            sb.append(sum % 10);
        }
        if(carry>0) sb.append(carry);

        System.out.println(sb.reverse().toString());
    }
}
