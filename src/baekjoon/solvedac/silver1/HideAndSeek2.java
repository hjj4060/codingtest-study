package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek2 {
    static int N, K;
    static boolean visit[] = new boolean[100001];
    static int jum[] = new int[100001];
    static int step = 0;

    static Queue<Integer> q;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jum[N] = step;
        visit[N] = true;

        q = new LinkedList<>();
        q.add(N);

        if(N == K) {
            System.out.println(step);
            return;
        }
        bfs();

        System.out.println(jum[K]);
    }

    static private void bfs() {
        while (!q.isEmpty()) {
            int n = q.poll();
            step++;

            int n1 = n - 1;
            int n2 = n + 1;
            int n3 = n * 2;

            if (n1 == K || n2 == K || n3 == K) {
                return;
            }

            if (n1 > 1 && n1 <= 100000 && !visit[n1]) {
                q.add(n1);
                jum[n1] = step;
                visit[n1] = true;
            }

            if (n2 > 1 && n2 <= 100000 && !visit[n2]) {
                q.add(n2);
                jum[n2] = step;
                visit[n2] = true;
            }

            if (n3 > 1 && n3 <= 100000 && !visit[n3]) {
                q.add(n3);
                jum[n3] = step;
                visit[n3] = true;
            }
        }
    }
}
