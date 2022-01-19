package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2606
public class Virus {
    static FastReader scan = new FastReader();
    static int v, e;
    static int result;
    static boolean visit[];
    static Queue<Integer> q = new LinkedList();

    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    public static void main(String[] args) {
        v = scan.nextInt();
        e = scan.nextInt();
        visit = new boolean[v + 1];

        int x, y;

        for(int i=1; i<=v; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            x = scan.nextInt();
            y = scan.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        BFS();

        System.out.println(result);
    }

    private static void BFS() {
        q.add(1);
        visit[1] = true;

        int vNum;

        while(!q.isEmpty()) {
            vNum = q.poll();

            for (int i: graph.get(vNum)) {

                if(visit[i]) continue;

                result++;
                q.add(i);
                visit[i] = true;
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
