package baekjoon.stepbystep.basic_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = n1; i <= n2; i++) {
            boolean sosu = true;
            if(i != 1) {
                for (int j = 2; j < i; j++) {
                    if(i % j == 0) {
                        sosu = false;
                        break;
                    }
                }
                if (sosu) arrayList.add(i);
            }
        }

        if(!arrayList.isEmpty()) {
            int sum = 0;


            for (Integer num : arrayList) {
                sum += num;
            }
            System.out.println(sum);
            System.out.println(arrayList.get(0));
        } else {
            System.out.println(-1);
        }
    }
}
