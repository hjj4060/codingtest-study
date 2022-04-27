package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697 숨바꼭질
public class HideAndSeek {
    static int N, K;
    static boolean visit[] = new boolean[100001];
    static int jum[] = new int[100001];
    static int step = 0;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();

        pro();
    }

    static private void pro() {
        if(N == K) {
            System.out.println(step);
            return;
        }
        bfs();

        System.out.println(jum[K]);
    }

    static private void bfs() {
        q.add(N);
        jum[N] = step;
        visit[N] = true;

        int n1, n2, n3;
        while (!q.isEmpty()) {
            int n = q.poll();

            if (n == K) {
                return;
            }

            n1 = n - 1;
            n2 = n + 1;
            n3 = n * 2;

            if (n1 >= 0 && n1 <= 100000 && !visit[n1]) {
                q.add(n1);
                jum[n1] = jum[n] + 1;
                visit[n1] = true;
            }

            if (n2 >= 0 && n2 <= 100000 && !visit[n2]) {
                q.add(n2);
                jum[n2] = jum[n] + 1;
                visit[n2] = true;
            }

            if (n3 >= 0 && n3 <= 100000 && !visit[n3]) {
                q.add(n3);
                jum[n3] = jum[n] + 1;
                visit[n3] = true;
            }
        }
    }

    static private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
