package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1316
public class GroupWordChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>(); //중복된 값 없애기 위해서 set 자료구조 이용

        int cnt = 0;

        Loop1 :
        for(int i=0; i<testCase; i++) {
            set.clear();
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                String s1 = null, s2 = null;

                s1 = s.substring(j, j + 1);
                if (j < s.length() - 1) s2 = s.substring(j + 1, j + 2);

                //첫문자와 다음문자를 비교해서 다른문자가 왔는데 set 안에 있으면 그룹단어로 체크안함
                if (s1.equals(s2)) {
                    continue;
                } else {
                    if (set.contains(s1)) {
                        continue Loop1;
                    } else {
                        set.add(s1);
                    }
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
