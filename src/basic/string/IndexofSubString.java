package basic.string;

/**
 * Input: String str[] = { “test”, “teacher" }
 * Output: “te”
 */
public class IndexofSubString {
    public static void main(String[] args) {
        String str[] = { "test", "teacher" };

        new IndexofSubString().sovle(str);
    }

    public void sovle(String[] str) {
        String firstStr = str[0];

        for(int i=1; i<str.length; i++) {
            while(str[i].indexOf(firstStr)!=0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
            }
        }
    }

    /*
    public void sovle(String[] str) {
        String firstString = str[0];

        while (firstString.length()>0) {
            if(str[1].indexOf(firstString)==-1) {
                firstString = firstString.substring(0, firstString.length() - 1);
            } else {
                System.out.println(firstString);
                break;
            };
        }
    }
    */
}
