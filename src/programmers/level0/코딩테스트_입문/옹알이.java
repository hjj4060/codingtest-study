package programmers.level0.코딩테스트_입문;

//https://school.programmers.co.kr/learn/courses/30/lessons/120956
public class 옹알이 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        /**
         * 설계
         * 1. availBabblinglList를 for문 돌려서 0번째 인덱스에 있으면 그 문자열을 계속 짜름
         * 2. 그 문자열의 길이가 0이면 answer 카운트 +1
         */

        System.out.println(sol.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
        System.out.println(sol.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] availBabblinglList = new String[]{"aya", "ye", "woo", "ma"};

            String subString = null;
            int sameCnt = 0;

            for (String strbabbling : babbling) {
                do{
                    sameCnt = 0;

                    //availBabblinglList babbling를 for문 돌아서 index 0에  이 있는지 확인
                    for (String availBabbling : availBabblinglList) {
                        if(strbabbling.indexOf(availBabbling) == 0) {
                            subString = availBabbling;
                            sameCnt++;
                            break;
                        }
                    }

                    //availBabblinglList가 0번째 인덱스에 있으면 그부분을 짜르고 저장
                    if(sameCnt > 0) {
                        strbabbling = strbabbling.substring(subString.length());
                    }
                }while(sameCnt != 0);

                if(strbabbling.equals("")) answer++;
            }

            return answer;
        }
    }
}
