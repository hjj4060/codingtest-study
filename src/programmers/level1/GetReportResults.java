package programmers.level1;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/92334 신고결과받기
public class GetReportResults {
    static Solution s = new Solution();

    public static void main(String[] args) {
        String id_list[] = {"muzi", "frodo", "apeach", "neo"};
       // String id_list[] = {"con", "ryan"};
        String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        //String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(s.solution(id_list, report, k)));
    }

    private static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            HashSet<String> reportSet = new HashSet<>();
            for (String rep : report) {
                reportSet.add(rep);
            }

            //신고받은 사람 - 신고자들
            HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
            for (String rep : reportSet) {
                String tmp[] = rep.split(" ");

                String reporter = tmp[0];
                String reportee = tmp[1];

                ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
                if (reporterList == null) reporterList = new ArrayList<>();

                reporterList.add(reporter);
                notifyListHash.put(reportee, reporterList);
            }

            notifyListHash.forEach((key, value) -> {
                System.out.println("{"+key+","+value+"}");
            });

            //신고자 - 정지당한사람수
            HashMap<String, Integer> notifyCountMap = new HashMap<>();

            for (String id : id_list) {
                notifyCountMap.put(id, 0);
            }
            
            for (String reportee : notifyListHash.keySet()) {
                if (notifyListHash.get(reportee).size() >= k) {

                    for (String reporter : notifyListHash.get(reportee)) {
                        notifyCountMap.put(reporter, notifyCountMap.get(reporter) + 1);
                    }
                }
                
            }
            notifyCountMap.forEach((key, value) -> {
                System.out.println("{"+key+","+value+"}");
            });

            for (int i = 0; i < id_list.length; i++) {
                answer[i] = notifyCountMap.get(id_list[i]);
            }

            return answer;
        }
    }
}
