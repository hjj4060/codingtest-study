package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2667
public class 단지번호붙이기 {
    /**
     * 1. 아이디어
     * - 미로 map에서 1이있으면 방문체크를 하고 BFS 돈다.
     * - BFS 나오면 단지 번호 수를 +1 한다.
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> houseCountList = new ArrayList<>();
    
    //가로와 세로 크기
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static final int[] dx = new int[]{0, -1, 0, 1};
    static final int[] dy = new int[]{-1, 0, 1, 0};

    static int justNumber = 0;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        solve();

        print();
    }

    private static void print() {
        sb.append(justNumber).append("\n");
        houseCountList.sort(Comparator.naturalOrder());

        for (Integer houseCount : houseCountList) {
            sb.append(houseCount).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    justNumber++;
                    isVisited[i][j] = true;
                    houseCountList.add(bfs(i, j));
                }
            }
        }
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int houseCount = 1;

        while (!queue.isEmpty()) {
            int[] curYX = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int qy = curYX[0] + dy[i];
                int qx = curYX[1] + dx[i];

                if (qy >= 0 && qy < N && qx >= 0 && qx < N && !isVisited[qy][qx] && map[qy][qx] == 1) {
                    queue.add(new int[]{qy, qx});
                    isVisited[qy][qx] = true;
                    map[qy][qx] = houseCount;
                    houseCount++;
                }
            }
        }

        return houseCount;
    }
}
