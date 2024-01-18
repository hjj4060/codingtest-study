package putshopman.string;

/**
 * 문자열 s의 substring에서 가장 긴 회문리턴하세요.
 * Input: s = "banana" Output: "anana"
 * Input: s = "babad" Output: "bab”
 * Input: s = "ac" Output: "a"
 * Input: s = "abba" Output: "abba"
 */
 public class Palindrome {
    public static void main(String[] args) {
        String s = "banana";

        new Palindrome().solve(s);
    }

    int start, end;
    public String solve(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len; i++) {
            System.out.println("i" + i);
        }

        return "";
    }
}
