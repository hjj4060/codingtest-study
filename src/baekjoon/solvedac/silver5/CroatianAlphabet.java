package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2941 크로아티아 알파벳
public class CroatianAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String table[] = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String s = st.nextToken();

        ArrayList<String> arrayList = new ArrayList<>();

        Loop1 :
        for(int i=0; i<s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            String s2 = null;
            String s3 = null;

            if (i < s.length() - 1) {
                s2 = s.substring(i, i + 2);
            }
            if (i < s.length() - 2) {
                s3 = s.substring(i, i + 3);
            }

            //3자리수 비교
            if(s3 != null) {
                for (String t : table) {
                    if (t.equals(s3)) {
                        arrayList.add(s3);
                        i = i + 2;
                        continue Loop1;
                    }
                }
            }

            //2자리수 비교
            if(s2 != null) {
                for (String t : table) {
                    if (t.equals(s2)) {
                        arrayList.add(s2);
                        i = i + 1;
                        continue Loop1;
                    }
                }
            }
            arrayList.add(s1);
        }

        System.out.println(arrayList.size());
    }
}
