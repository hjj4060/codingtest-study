package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2178
public class 미로탐색 {
    /**
     * 1. 아이디어
     * - (1,1)위치에서 (N,M)위치로가는 최소의 칸 수 구하기
     * -
     * <p>
     * 2. 시간 복잡도
     * - 100 * 100 = 10000
     * <p>
     * 3. 변수
     * - 미로 : map[mapYSize][mapXSize]
     * - 방문체크 : isVisited[mapYSize][mapXsize]
     * - 방문 : dx[]{0, 1, 0, -1}, dy[]{-1, 0, 1, 0}
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int mapXSize, mapYSize;
    static boolean[][] isVisited;
    static final int[] dy = new int[]{1, 0, -1, 0};
    static final int[] dx = new int[]{0, 1, 0, -1};

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        mapYSize = Integer.parseInt(st.nextToken());
        mapXSize = Integer.parseInt(st.nextToken());

        map = new int[mapYSize][mapXSize];
        isVisited = new boolean[mapYSize][mapXSize];

        for (int y = 0; y < mapYSize; y++) {
            st = new StringTokenizer(br.readLine());
            String inputStr = st.nextToken();

            for (int x = 0; x < mapXSize; x++) {
                map[y][x] = inputStr.charAt(x) - '0';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        solve();

        print();
    }

    private static void print() {
        System.out.print(map[mapYSize - 1][mapXSize - 1]);
    }

    private static void solve() {
        isVisited[0][0] = true;
        bfs(0, 0);
    }

    private static void bfs(int mapY, int intX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{mapY, intX});

        while (!queue.isEmpty()) {
            int[] curXY = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int qy = dy[i] + curXY[0];
                int qx = dx[i] + curXY[1];
                int curMin = map[curXY[0]][curXY[1]];

                if (0 <= qx && qx < mapXSize && 0 <= qy && qy < mapYSize && map[qy][qx] == 1 && !isVisited[qy][qx]) {
                    map[qy][qx] = curMin + 1;
                    isVisited[qy][qx] = true;
                    queue.add(new int[]{qy, qx});
                }
            }
        }
    }
}
