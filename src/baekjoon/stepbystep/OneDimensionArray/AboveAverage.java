package baekjoon.stepbystep.OneDimensionArray;

//https://www.acmicpc.net/problem/4344

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 * 문제
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 *
 * 입력
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 *
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
 * 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 *
 * 출력
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */

public class AboveAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedHashMap<ArrayList<Integer>, Double> hashMap = new LinkedHashMap<ArrayList<Integer>, Double>();

        int C = Integer.parseInt(st.nextToken());

        //테스트케이스
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> al = new ArrayList<>();
            //학생수
            int stuCnt = Integer.parseInt(st.nextToken());

            //학생수만큼 스코어 입력
            for(int j =0; j<stuCnt; j++) {
                int score = Integer.parseInt(st.nextToken());
                al.add(score);
            }

            hashMap.put(al, 0.0);
        }

        new AboveAverage().solve(hashMap);
    }
    public void solve(LinkedHashMap<ArrayList<Integer>, Double> hashMap) {
        int sum = 0;
        double average = 0;

        for (ArrayList<Integer> al : hashMap.keySet()) {
            for (Integer i : al) {
                sum += i;
            }
            average = (double)sum/al.size();
            hashMap.put(al, average);
            sum = 0;
        }
        int cnt = 0;
        for (ArrayList<Integer> al : hashMap.keySet()) {
            for (Integer i : al) {
                if ((double)i > hashMap.get(al)) {
                    cnt++;
                };
            }

            double result = (double)cnt  / al.size() * 100.0;
            //System.out.println(Math.round(result * 1000) / 1000.0 + "%");
            System.out.printf("%.3f%%\n", result);
            cnt = 0;
        }
    }
}
