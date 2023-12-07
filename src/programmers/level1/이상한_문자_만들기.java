package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("   sp   ace      a     "));
    }

    static class Solution {
        public String solution(String s) {
            String answer = "";

            /**
             * 첫번째 문제풀이
             * 1. 문자열 s를 공백단위로 split해서 배열에 담는다.
             * 2. 배열에 담긴 문자열을 길이만큼 for문을 돌려서 짝수번째면 대문자 홀수번째면 소문자로 만든다
             * 3. 각 배열에 담긴 문자열을 공백단위로 이어 붙여서 return 한다.
             * 
             * 문제풀이 문제점
             * 공백 개수를 동일하게 하지 못함
             *
             * 문제점 해결(너무 꼼수로 해결한것 같음)
             * 맨 마지막 공백이 문자열이면 문자 넣어줘서 마지막 공백도 split된 배열에 들어가도록 함
             */

            //문자열 마지막이 공백인지 유무
            Boolean lastIsSpace = false;

            //문자열에서 마지막이 공백이면 아무 문자 넣어주기
            if(s.charAt(s.length() - 1) == ' ') {
                lastIsSpace = true;
                s += "s";
            }

            String[] strArray = s.split(" ");
            String[] formattedStrArray = new String[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                formattedStrArray[i] = strFotmattingFunction(strArray[i]);
            }

            //마지막 문자가 공백이 아니면
            if(!lastIsSpace) {
                for (int i = 0; i < formattedStrArray.length; i++) {
                    if(i != formattedStrArray.length - 1) {
                        answer += formattedStrArray[i] + " ";
                    } else {
                        answer += formattedStrArray[i];
                    }
                }
            //마지막 문자가 공백이면
            } else {
                for (int i = 0; i < formattedStrArray.length - 1; i++) {
                    answer += formattedStrArray[i] + " ";
                }
            }

            return answer;
        }

        /* 문자열이면 문자열을 짝수번째는 대문자 홀수번쨰는 소문자로 바꿔주는 함수 */
        public String strFotmattingFunction(String str) {
            String answer = "";
            char[] stringCharArray = str.toCharArray();

            for(int i = 0; i < str.length(); i++) {
                if(i % 2 == 0) {
                    answer += Character.toUpperCase(stringCharArray[i]);
                } else {
                    answer += Character.toLowerCase(stringCharArray[i]);
                }
            }

            return answer;
        }
    }
}
