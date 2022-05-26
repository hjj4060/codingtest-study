package programmers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//https://programmers.co.kr/learn/courses/30/lessons/92334 신고결과받기
public class GetReportResults {
    static Solution s = new Solution();

    public static void main(String[] args) {
        String id_list[] = {"muzi", "frodo", "apeach", "neo"};
       // String id_list[] = {"con", "ryan"};
        String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        //String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        s.solution(id_list, report, k);
    }

    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = {};

            HashMap<String, Integer> id_map = new HashMap<>();
            HashSet<String> set = new HashSet<>();

            for (String s : id_list) {
                id_map.put(s, 0);
            }

            for (String s : report) {
                set.add(s);
            }

            StringTokenizer st;
            String re[];
            for (String s : set) {
                st = new StringTokenizer(s);

                re = s.split(" ");

                for (String key : id_map.keySet()) {
                    if (key.equals(re[1])) {
                        id_map.put(re[1], id_map.get(re[1]) + 1);
                    }
                }
            }

            id_map.forEach((key, value) -> {
                        System.out.println("{"+key+","+value+"}");
                    });


            return answer;
        }
    }
}
