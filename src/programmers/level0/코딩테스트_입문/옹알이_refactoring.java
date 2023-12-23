package programmers.level0.코딩테스트_입문;

public class 옹알이_refactoring {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
        System.out.println(sol.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            String[] str = {"aya", "ye", "woo", "ma"};

            for(String babble : babbling) {
                for(String s : str) {
                    babble = babble.replace(s, "");
                }

                if(babble.isEmpty()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
