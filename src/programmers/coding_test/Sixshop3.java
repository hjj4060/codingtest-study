package programmers.coding_test;

import java.util.HashMap;

public class Sixshop3 {
    public static void main(String[] args) {
        Sixshop3 sixshop3 = new Sixshop3();
        sixshop3.solution(3, new int[]{4,2,2,5,3});
    }

    public int[] solution(int N, int[] coffee_times) {
        int[] answer = {};

        HashMap<Integer, Integer> coffeeTimesMap = new HashMap();

        for (int coffee_time : coffee_times) {
            coffeeTimesMap.put(coffee_time, 0);
        }

        return answer;
    }
}
