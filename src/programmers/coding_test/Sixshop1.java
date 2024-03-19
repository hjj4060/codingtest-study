package programmers.coding_test;

public class Sixshop1 {
    public static void main(String[] args) {
        Sixshop1 solution = new Sixshop1();
        int[] estimates = {5,1,9,8,10,5};

        System.out.println(solution.solution(estimates, 3));
    }

    public int solution(int[] estimates, int k) {
        int l_index = 0;
        int r_index = k;

        int answer = 0;

        while (r_index <= estimates.length) {
            int sum = 0;
            for (int i = l_index; i < r_index; i++) {
                sum += estimates[i];
            }
            answer = Math.max(answer, sum);

            l_index++;
            r_index++;
        }

        return answer;
    }
}
