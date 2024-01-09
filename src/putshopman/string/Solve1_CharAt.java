package putshopman.string;

public class Solve1_CharAt {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "123";
        System.out.println(new Solve1_CharAt().solve(num1, num2));
    }

    public String solve(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int numLength = num1.length() - 1;

        for (int i = numLength; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(i) - '0';

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
