package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15649
public class N과M_15649 {
    /**
     * 아이디어
     * 1. 1부터 N중에 하나를 선택한뒤
     * 2. 다음 1부터 N부터 선택할 때 이미 선택한 값이 아닌 경우 선택
     * 3. M개를 선택할 경우 프린트
     *
     * 시간복잡도(재귀는 2억이 넘지 않아야함)
     * 1. N^N : 중복이 가능, N = 8 까지 가능
     * 2. N! : 중복이 불가, N = 10 까지 가능
     *
     * 자료구조
     * 1. 방문 여부 확인 배열 : bool[]
     * 2. 선택한 값 입력 배열 : int[]
     */

    static int N, M;
    static int[] result;
    static boolean[] isVisited;
    static ArrayList<int[]> resultList = new ArrayList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        isVisited = new boolean[N + 1];
    }

    public static void main(String[] args) throws IOException {
        input();

        solve();

        print();
    }

    private static void print() {
        for (int[] arr : resultList) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() throws IOException {
        recur(0);
    }

    private static void recur(int depth) {
        if (depth == M) {
            int[] arr = result.clone();
            resultList.add(arr);

            return;
        }
        for(int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;

                result[depth] = i;
                recur(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
