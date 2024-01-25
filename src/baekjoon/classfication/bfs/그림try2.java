package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림try2 {

    /**
     * 아이디어
     * 1. 2중 for 돌면서 값 1인것 찾고 방문 체크 후 BFS함수 실행
     * 2. BFS 돌면서 그림 개수 + 1  BFS 반환값으로 그림수
     *
     * 자료구조
     * 1. 지도 : int[][] map
     * 2. 동서남북 search : int[] dx, int[] dy
     * 3. 방문체크 : boolean[][] isVisited
     * 4. 최대 그림 개수
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int[][] map = null;
    static int mapYsize, mapXsize, printCount, maxPrintSize;
    static boolean[][] isVisited = null;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        //세로, 가로
        mapYsize = Integer.parseInt(st.nextToken());
        mapXsize = Integer.parseInt(st.nextToken());

        //방문 경로 배열과 방문 체크 배열 생성
        map = new int[mapYsize][mapXsize];
        isVisited = new boolean[mapYsize][mapXsize];

        for (int i = 0; i < mapYsize; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < mapXsize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();

        solve();

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(printCount).append("\n");
        sb.append(maxPrintSize).append("\n");

        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < mapYsize; i++) {
            for (int j = 0; j < mapXsize; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    printCount++;
                    isVisited[i][j] = true;

                    maxPrintSize = Math.max(maxPrintSize, bfs(i, j));
                }
            }
        }
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int printSize = 1;

        while (!queue.isEmpty()) {
            int[] curYX = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int ty = curYX[0] + dy[i];
                int tx = curYX[1] + dx[i];

                if (ty >= 0 && ty < mapYsize && tx>=0 && tx < mapXsize && map[ty][tx] == 1 && !isVisited[ty][tx]) {
                    printSize++;
                    isVisited[ty][tx] = true;
                    queue.add(new int[]{ty, tx});
                }
            }
        }

        return printSize;
    }


}
