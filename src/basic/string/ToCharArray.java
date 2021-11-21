package basic.string;

/*
    문제2) toCharArray()를 이용하여 괄호 쌍 맞추기
    Input: String s = "in(f(lea)r)n)";
    Output: "in(f(lea)r)n"
 */
public class ToCharArray {
    public static void main(String[] args) {
        // String s = "(a(b(c)d)";
        String s = ")()(";

        System.out.println( new ToCharArray().solve(s) );
    }

    public String solve(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openBrace=0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                openBrace++;
            } else if(c == ')') {
                if(openBrace == 0) continue;
                openBrace--;
            }
            sb.append(c);
        }

        /*
            for(int i = 0; sb.length() > i; i++) {
                if(sb.charAt(i)=='(' && openBrace-- > 0 ) continue;

                result.append(sb.charAt(i));
            }
        */
        //()(
        for(int i=sb.length()-1; i>=0; i--) {
            if(sb.charAt(i)=='(' && openBrace-- > 0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
