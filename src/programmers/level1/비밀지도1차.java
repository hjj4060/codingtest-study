package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class 비밀지도1차 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            /**
             * 문제풀이
             * arr1, arr2를 2진수로 바꾼다.
             * 자릿수를 앞에서부터 0을 붙여 n자리만큼 채워준다.
             * 자릿수 채워진 2개의 2진수로 답을 내린다.
             */

            for(int i = 0; i < n; i++) {
                String binaryValue1 = formattingBinary(n, arr1[i]);
                String binaryValue2 = formattingBinary(n, arr2[i]);

                answer[i] = binaryMergeAndDecode(binaryValue1, binaryValue2);
            }

            return answer;
        }
        
        //숫자를 자릿수 0부터 채워서 2진수로 만들어주는 함수
        String formattingBinary(int digit, int num) {
            String binaryValue = "";

            //앞자리 0으로 붙여주기 위한 String
            String toAttachDigit = "";

            binaryValue = Integer.toBinaryString(num);

            for(int i = 0; i < digit - binaryValue.length(); i++) {
                toAttachDigit += "0";
            }

            return toAttachDigit + binaryValue;
        }

        String binaryMergeAndDecode(String binaryValue1, String binaryValue2) {
            String mergedBinaryValue = "";

            char[] binaryCharArr1 = binaryValue1.toCharArray();
            char[] binaryCharArr2 = binaryValue2.toCharArray();

            for(int i = 0; i < binaryValue1.length(); i++) {
                if(binaryCharArr1[i] == '1' || binaryCharArr2[i] == '1') {
                    mergedBinaryValue += "#";
                } else {
                    mergedBinaryValue += " ";
                }
            }

            return mergedBinaryValue;
        }
    }
}
