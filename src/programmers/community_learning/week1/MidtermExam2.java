package programmers.community_learning.week1;

import java.util.*;

public class MidtermExam2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] booked = new String[][]{{"09:10", "lee"}};
        String[][] unbooked = new String[][]{{"09:00", "kim"}, {"09:05", "bae"}};

        System.out.println(Arrays.toString(sol.solution(booked, unbooked)));
    }

    private static class Solution {
        public String[] solution(String[][] booked, String[][] unbooked) {
            TreeMap<Integer, HashMap<String, Boolean>> reservationMap = new TreeMap<>();

            for (String[] strings : booked) {
                String s[] = strings[0].split(":");
                int time = Integer.parseInt(s[0] + s[1]);
                HashMap<String, Boolean> bookingMap = new HashMap<>();
                bookingMap.put(strings[1], true);

                reservationMap.put(time, bookingMap);
            }

            for (String[] strings : unbooked) {
                String s[] = strings[0].split(":");
                int time = Integer.parseInt(s[0] + s[1]);
                HashMap<String, Boolean> unbookingMap = new HashMap<>();
                unbookingMap.put(strings[1], false);

                reservationMap.put(time, unbookingMap);
            }


            ArrayList<String> answerList = new ArrayList<String>();

            do {
                Integer time = reservationMap.firstKey();
                String name = String.valueOf(reservationMap.get(time).keySet());

                //System.out.println(time + name + bookCheck);

                answerList.add(name);
                reservationMap.remove(time);

                reservationMap.get(time);


                for (Integer integer : reservationMap.keySet()) {
                    if (time + 10 >= integer) {
                        boolean bookCheck = false;

                        for (String s : reservationMap.get(integer).keySet()) {
                            bookCheck = reservationMap.get(integer).get(s);

                            if(bookCheck) {
                                answerList.add(s);
                                reservationMap.remove(integer);
                            }
                        }
                    }
                }
            } while(!reservationMap.isEmpty());
            String[] answer = new String[answerList.size()];

            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }
}
