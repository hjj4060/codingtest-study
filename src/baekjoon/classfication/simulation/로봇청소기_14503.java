package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14503
public class 로봇청소기_14503 {
    static int mapX;
    static int mapY;
    static int robotX;
    static int robotY;
    static int robotDirection;
    static int[][] map;
    static boolean[][] cleaningChk;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapY = Integer.parseInt(st.nextToken());
        mapX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robotY = Integer.parseInt(st.nextToken());
        robotX = Integer.parseInt(st.nextToken());
        robotDirection = Integer.parseInt(st.nextToken());

        map = new int[mapY][mapX];
        cleaningChk = new boolean[mapY][mapX];

        for (int i = 0; i < mapY; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapX; j++) {
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
        int cnt = 0;
        for (int i = 0; i < mapY; i++) {
            for (int j = 0; j < mapX; j++) {
                if(cleaningChk[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void solve() {
        dfs(robotY, robotX, robotDirection);
    }

    private static void dfs(int robotY, int robotX, int robotDirection) {
        //현재위치 청소
        if (map[robotY][robotX] == 0 && !cleaningChk[robotY][robotX]) {
            cleaningChk[robotY][robotX] = true;
        }

        //현재칸의 주변 4칸중 청소되지 않는 빈칸이 있는경우
        for (int i = 0; i < 4; i++) {
            //반시계 방향으로 90도 회전
            robotDirection = (robotDirection + 3) % 4;
            int ny = robotY + dy[robotDirection];
            int nx = robotX + dy[robotDirection];

            if (ny >= 0 && nx >= 0 && ny < mapY && nx < mapX && map[ny][nx] == 0 && !cleaningChk[ny][nx]) {
                dfs(ny, nx, robotDirection);
                return;
            }
        }

        int back = (robotY + 2) % 4;
        int by = robotY + dy[robotDirection];
        int bx = robotX + dx[robotDirection];

        if (by >= 0 && bx >= 0 && by < mapY && bx < mapX && map[by][bx] != -1) {
            dfs(by, bx, back);
        }
    }
}
