package putshopman.string;

public class Solve2_toCahrArray {
    public static void main(String[] args) {
        String s = ")()(";
        System.out.println("result: " + new Solve2_toCahrArray().solve(s));
    }

    public String solve(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openBrace = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openBrace++;
            } else if (c == ')') {
                if (openBrace == 0) {
                    continue;
                }

                openBrace--;
            }
            sb.append(c);
        }

        //openbrace가 0일때까지 openbrace를 뒤에서 부터 지운다.
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (openBrace > 0 && sb.charAt(i) == '(') {
                openBrace--;
                continue;
            }

            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
}
