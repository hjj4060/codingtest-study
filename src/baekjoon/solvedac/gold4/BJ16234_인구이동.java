package baekjoon.solvedac.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16234
public class BJ16234_인구이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    //N: NXN 지도 크기, L이상 R명 이하일 때 인구 이동
    static int N, L, R;
    static int[][] map;

    //이동 경로 배열
    static boolean[][] visited = null;
    static int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map =  new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        //인구이동 카운트
        int peopleMoveCount = 0;

        //인구이동할 나라가 있는지 찾기
        while (true) {
            int[] startLocation = seekStartLocation();

            if (startLocation == null) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int movedX = i + dir[0];
                        int movedY = j + dir[1];

                        if(movedX >= 0 && movedY >= 0 && movedX < N && movedY < N) {
                            int diffPeopleCount = Math.abs(map[i][j] - map[movedX][movedY]);

                            if(L <= diffPeopleCount && diffPeopleCount <= R) {
                                bfs(i, j);
                                peopleMove();
                                peopleMoveCount++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(peopleMoveCount);
    }

    //인구 이동할 나라가 있는지 찾기
    public static int[] seekStartLocation() {
        int[] startLocation = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] dir : dirs) {
                    int movedX = i + dir[0];
                    int movedY = j + dir[1];

                    if(movedX >= 0 && movedY >= 0 && movedX < N && movedY < N) {
                        int diffPeopleCount = Math.abs(map[i][j] - map[movedX][movedY]);

                        if(L <= diffPeopleCount && diffPeopleCount <= R) {
                            startLocation = new int[]{i, j};
                            return startLocation;
                        }
                    }
                }
            }
        }

        return startLocation;
    }

    public static void peopleMove() {
        /**
         * 인구이동
         * map에서 true인 개수를 찾고 각 나라에 배치할 인구수를 계산한다.
         * 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
         *
         */

        //배치할 인구수
        int setPeopleCount = 0;
        int trueCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    trueCount++;
                    setPeopleCount += map[i][j];
                }
            }
        }

        setPeopleCount = setPeopleCount / trueCount;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    map[i][j] = setPeopleCount;
                }
            }
        }

        //인구 이동 하고 나서 visited 초기화
        visited = new boolean[N][N];
    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //0, 0
            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int movedX = curX + dir[0];
                int movedY = curY + dir[1];

                if(movedX >= 0 && movedY >= 0 && movedX < N && movedY < N && !visited[movedX][movedY]) {
                    int diffPeopleCount = Math.abs(map[curX][curY] - map[movedX][movedY]);

                    if(L <= diffPeopleCount && diffPeopleCount <= R) {
                        visited[movedX][movedY] = true;
                        queue.add(new int[]{movedX, movedY});
                    }
                }
            }
        }
    }
}
