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

    static int result = 0;

    public static void main(String[] args) {
        N = scan.nextInt();  //정점의 개수
        M = scan.nextInt();  //간선의 개수

        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
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

        System.out.println(result);
    }

    static private void BFS() {
        int x;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int g:graph.keySet()) {
            if(visit[g] == false) {
                q.add(g);
                result++;
                visit[g] = true;
            }

            while (!q.isEmpty()) {
                x = q.poll();

                arr = graph.get(x);

                for (int i:arr) {
                    if(visit[i] == true) continue;

                    q.add(i);
                    visit[i] = true;
                }
            }
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
