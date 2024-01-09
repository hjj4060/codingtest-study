package putshopman.string;

public class Solve3_indexOfSubString {
    public static void main(String[] args) {
        String[] str = {"test", "teacher"};
        System.out.println(new Solve3_indexOfSubString().solve(str));
    }

    public String solve(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String firstStr = strs[0]; //"test"

        for (int i = 1; i < strs.length; i++) { //"teacher"
            while (strs[i].indexOf(firstStr) != 0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1); //뒤에서 한글자씩 지움
            }
        }

        return firstStr;
    }
}