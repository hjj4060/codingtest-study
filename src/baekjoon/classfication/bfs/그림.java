package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1926
public class 그림 {
    /**
     * 1. 아이디어
     *   - 2중 for => 값 1 && 방문 => BFS
     *   - BFS 돌면서 그림 개수 +1, 최대값을 갱신
     *
     *  2. 시간복잡도
     *    - BFS : O(V+E)
     *    - V : M * N = 500 * 500
     *    - E : V * 4 = 4(방향) * 500 * 500
     *    - V + E : 25만 + 100만
     *
     * 3. 자료구조
     *   - 그래프 전체 지도 : int[][]
     *   - 방문 여부 : boolean[][]
     *   - 전체 그림 개수 : int
     *   - 최대 그림 크기 : int
     *   - Queue(BFS)
     *   - 동서남북 x좌표 : int[]
     *   - 동서남북 y좌표 : int[]
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int mapYsize, mapXsize;
    static int[][] map = null;
    static boolean[][] isVisited = null;

    //0 1 오른쪽, 1 0 위쪽, 0 -1 왼쪽, -1 0 밑에쪽
    private final static int[] dy = new int[]{0, 1, 0, -1};
    private final static int[] dx = new int[]{1, 0, -1, 0};

    static int paintingCount = 0; //전체 그림 개수
    static int maxPaintingSize = 0; //제일큰 그림 크기

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        //도화지 세로크기 y, 가로크기 x
        mapYsize = Integer.parseInt(st.nextToken());
        mapXsize = Integer.parseInt(st.nextToken());

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

        sb.append(paintingCount).append("\n");
        sb.append(maxPaintingSize).append("\n");

        System.out.println(sb.toString());
    }

    private static void solve() {
        //2중 for => 값 1 && 방문 => BFS
        for (int i = 0; i < mapYsize; i++) {
            for (int j = 0; j < mapXsize; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    /**
                     * 방문체크 true
                     * 전체 그림 갯수를 + 1
                     * BFS > 그림 크기를 구해주고
                     * 최대값 갱신
                     */
                    isVisited[i][j] = true;
                    paintingCount++;
                    maxPaintingSize = Math.max(maxPaintingSize, bfs(i, j));
                }
            }
        }
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int mapSize = 1;

        while(!queue.isEmpty()) {
            int[] que = queue.poll();
            int qy = que[0];
            int qx = que[1];

            for (int i = 0; i < dx.length; i++) {
                int ny = qy + dy[i];
                int nx = qx + dx[i];

                /**
                 * map 사이즈 체크
                 * 방문한곳 1인지 체크
                 * 방문여부 체크
                 */
                if (0 <= ny && ny < mapYsize && 0 <= nx && nx < mapXsize && map[ny][nx] == 1 && !isVisited[ny][nx]) {
                    isVisited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                    mapSize++;
                }
            }

        }

        return mapSize;
    }
}
