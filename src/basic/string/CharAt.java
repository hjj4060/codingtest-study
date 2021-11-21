package basic.string;

/*
    문제1) charAt()를 이용하여 문자열 숫자 더하기
    Input: "123", "888"
    Output: "1011"
 */
public class CharAt {
    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "888";

        System.out.println(new CharAt().solve(nums1, nums2));
    }

    public String solve(String nums1, String nums2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int num1Length = nums1.length()-1; //2
        int num2Length = nums2.length()-1; //2

        while(num1Length >= 0 || num2Length >= 0) {
            int n1 = 0, n2 = 0, sum = 0;
            if(num1Length >= 0) n1 = nums1.charAt(num1Length) - '0'; //String -> Int
            if(num2Length >= 0) n2 = nums2.charAt(num2Length) - '0'; //String -> Int

            sum = n1+n2+carry;
            carry = sum/10;
            sb.append(sum%10);

            num1Length--;
            num2Length--;
        }
        if(carry!=0) sb.append(carry);

        return sb.reverse().toString();
    }
}
