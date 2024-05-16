package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
    static int mapX;
    static int mapY;
    static int[] robotLocation = new int[2];
    static int robotDirection;
    static int[][] map;
    static boolean[][] cleaningChk;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapY = Integer.parseInt(st.nextToken());
        mapX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robotLocation[0] = Integer.parseInt(st.nextToken());
        robotLocation[1] = Integer.parseInt(st.nextToken());
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

        for (int i = 0; i < mapY; i++) {
            for (int j = 0; j < mapX; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        solve();
    }

    private static void solve() {

    }
}
