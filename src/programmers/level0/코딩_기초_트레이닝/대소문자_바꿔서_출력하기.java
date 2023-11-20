package programmers.level0.코딩_기초_트레이닝;

import java.util.Scanner;


//Character.isUpperCase(a) : a값이 대분자면 true
//Character.toUpperCase(a) : a값을 대문자로 변환
public class 대소문자_바꿔서_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char ch[] = a.toCharArray();

        for (char c : ch) {
            //System.out.println(Character.isUpperCase(c));

            if(Character.isUpperCase(c)) {
                System.out.print(Character.toLowerCase(c));
            }else {
                System.out.print(Character.toUpperCase(c));
            }
        }


    }
}
