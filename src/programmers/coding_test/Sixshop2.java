package programmers.coding_test;

import java.util.*;

public class Sixshop2 {
    public static void main(String[] args) {
        Sixshop2 solution = new Sixshop2();
        String[] user_scores = {"alex111 100", "cheries2 200", "coco 150", "luna 160", "alex111 120", "coco 300", "cheries2 110"};

        System.out.println(solution.solution(3, user_scores));
    }
    public int solution(int K, String[] user_scores) {
        int answer = 0;

        HashMap<String, Integer> userScoresRankMap = new HashMap<>();

        for (String user_score : user_scores) {
            String[] user_score_temp = user_score.split(" ");
            String userName = user_score_temp[0];
            Integer userScore = Integer.parseInt(user_score_temp[1]);

            if (userScoresRankMap.size() < K) {
                userScoresRankMap.put(userName, userScore);

                userScoresRankMap.forEach((key, value) -> System.out.println(key + " " + value));
                System.out.println("=======");

                answer++;
            } else {
                if (!userScoresRankMap.containsKey(userName)) {
                    for (String compareUserName : userScoresRankMap.keySet()) {
                        if (userScoresRankMap.get(compareUserName) < userScore) {
                            userScoresRankMap.remove(compareUserName);
                            userScoresRankMap.put(userName, userScore);
                            answer++;

                            userScoresRankMap.forEach((key, value) -> System.out.println(key + " " + value));
                            System.out.println();
                        }
                    }
                }
            }
        }
        return answer;
    }
}
