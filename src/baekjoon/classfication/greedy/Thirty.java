package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/10610
public class Thirty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();

        //문자열 전체에서 한문자씩 보고 0이 없으면 -1 return
        Boolean b = false; //0이 있으면 true
        for (char c : N.toCharArray()) {
            if(c == '0') {
                b = true;
                break;
            }
        }

        if (b == false) {
            System.out.println(-1);
            return;
        }

        //문자열을 높은 숫자대로 정렬
        Integer[] iarr = new Integer[N.length()];

        for (int i = 0; i < iarr.length; i++) {
            iarr[i] = N.charAt(i) - '0';
        }

        Arrays.sort(iarr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        //정렬한 숫자 배열 다시 문자열로 변환
        for (int i = 0; i < iarr.length; i++) {
            sb.append(iarr[i]);
        }

        //System.out.println(sb.substring(7,8));


        for (int i = 0; i < sb.length() - 1; i++) {
            String s = sb.substring(i, sb.length());

            int tmp = Integer.parseInt(s);
            //System.out.println(tmp);

            if ((tmp % 30) == 0) {
                System.out.println(tmp);
                return;
            }
        }
        System.out.println(-1);
    }
}
