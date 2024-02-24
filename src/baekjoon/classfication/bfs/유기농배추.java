package baekjoon.classfication.bfs;

//https://www.acmicpc.net/problem/1012


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    /**
     * 설계
     * 1. 2차원 배열 map을 만듬
     * 2. 2중 for문으로 map을 돌면서 1을 찾고 bfs() 실행
     * 3. 1을 찾을 때마다 필요한 흰 지렁이 개수 + 1
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int[][] map = null;
    static int mapY, mapX;

    static boolean[][] isVisited = null;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    //필요한 흰 지렁이 개수
    static int requiredWorms = 0;

    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        mapX = Integer.parseInt(st.nextToken());
        mapY = Integer.parseInt(st.nextToken());
        int cabbageCnt = Integer.parseInt(st.nextToken());

        map = new int[mapY][mapX];
        isVisited = new boolean[mapY][mapX];

        for (int i = 0; i < cabbageCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int testCaseCnt = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCaseCnt; t++) {
            input();

            solve();
        }

        System.out.println(sb.toString());
    }



    private static void solve() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    bfs(y, x);
                    requiredWorms++;
                    isVisited[y][x] = true;
                }
            }
        }

        sb.append(requiredWorms).append("\n");
        requiredWorms = 0;
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] curYX = queue.poll();

            int curY = curYX[0];
            int curX = curYX[1];

            for (int i = 0; i < dx.length; i++) {
                int qy = dy[i] + curY;
                int qx = dx[i] + curX;

                if (qy >= 0 && qy < mapY && qx >= 0 && qx < mapX && map[qy][qx] == 1 && !isVisited[qy][qx] ) {
                    queue.add(new int[]{qy, qx});
                    isVisited[qy][qx] = true;
                }
            }
        }

    }
}
