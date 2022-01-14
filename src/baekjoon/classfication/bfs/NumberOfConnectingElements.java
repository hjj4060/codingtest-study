package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/11724
public class NumberOfConnectingElements {
    static FastReader scan = new FastReader();

    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    static int N, M;
    static boolean visit[];
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) {
        N = scan.nextInt();  //정점의 개수
        M = scan.nextInt();  //간선의 개수

        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        int x, y;
        for (int i = 0; i < M; i++) {
            x = scan.nextInt();
            y = scan.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        BFS();
    }

    static private void BFS() {


            while (!q.isEmpty()) {

            }

    }


    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
