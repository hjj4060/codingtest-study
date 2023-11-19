package programmers.community_learning.week2;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42578?language=java 위장
public class Camouflage {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution.solution(clothes));
    }

    private static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String, String> clothesMap = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                clothesMap.put(clothes[i][0], clothes[i][1]);
            }

            TreeSet<String> clothCombination = new TreeSet<>();
            Iterator<String> iterator = clothesMap.keySet().iterator();

            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = clothesMap.get(key);

                clothCombination.add(key);

                for (String key2 : clothesMap.keySet()) {
                    String value2 = clothesMap.get(key2);
                    if (!value.equals(value2)) {
                        //key가 key2값보다 크면 1 아니면 -1 같으면 0
                        if(key.compareTo(key2) >= 0) {
                            clothCombination.add(key + key2);
                        } else {
                            clothCombination.add(key2 + key);
                        }

                    }
                }
            }
            answer = clothCombination.size();

            return answer;
        }
    }
}


