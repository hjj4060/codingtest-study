package structure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayStudy {
    public static void main(String[] args) {
        //배열 생성방법
        int[] a = new int[5]; //길이가 5인 int형 배열 생성
        String b[] = new String[5]; //길이가 5인 String형 배열 생성

        //구성요소 참조
        System.out.println(a[0]); //0 출력
        System.out.println(b[0]); //null 출력

        //구성요소의 개수 알수있는 length
        System.out.println(a.length); //5 출력

        //배열생성시 각 요소 초기화 방법
        int c[] = new int[]{1, 2, 3, 4, 5};

        //배열 복제방법
        int d[] = c.clone();
        System.out.println(Arrays.toString(d)); //[1, 2, 3, 4, 5] 출력


        //ArrayList 생성방법
        List<Integer> list1 = new ArrayList<Integer>(); //List 인터페이스로 객체 생성
        ArrayList<Integer> list2 = new ArrayList<Integer>(); //ArrayList 클래스로 객체 생성
        ArrayList<Integer> list3 = new ArrayList<>(); //JDK 1.7부터는 객체 생성시 타입을 추정할 수 있으면 생략 가능

        list1 = new LinkedList<Integer>(); //List로 선언된 변수는 필요에 따라 다른 List 클래스를 쓸수 있는 구현상의 유연성을 제공한다.

        list2.add(1); //값 추가(인덱스는 0번부터)
        list2.add(2);
        list2.add(2, 3); //특정인덱스에 값을 넣을수 있음.
        System.out.println(list2.get(1)); //get() 함수로 인덱스 값 추출
        list2.remove(2); //remove() 함수로 인덱스 삭제
    }
}
