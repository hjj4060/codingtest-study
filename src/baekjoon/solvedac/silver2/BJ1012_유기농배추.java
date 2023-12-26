package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1012
public class BJ1012_유기농배추 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    final static int[][] search = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        for(int i = 0; i < T; i++) {
            int[][] cabbageMap = createCabbageMap();
            boolean[][] visitMap = new boolean[cabbageMap.length][cabbageMap[0].length];
            int wormCount = 0;

            /**
             * BFS
             * 1. cabbageMap에서 1을 찾는다.
             * 2. visit MAP을 만든다
             * 3. 상하좌우 검색용 배열을 만든다.
             * 4. 1을 찾은 좌표값에서 Queue를 만들어서 넣는다.
             * 5. 찾은 1 좌표값에서 상하좌우 검색한다 검색되면 visit를 true로 변경한다.
             * 6. 1을 찾을때마다 answer를 늘린다.
             */

            for(int j = 0; j < cabbageMap.length; j++) {
                for(int k = 0; k < cabbageMap[i].length; k++) {
                    if(visitMap[j][k]) {
                        continue;
                    }

                    if(cabbageMap[j][k] == 1) {
                        int[] startNode = new int[]{j, k};
                        wormCount++;

                        cabbageMap[j][k] = wormCount;
                        visitMap[j][k] = true;

                        bfs(cabbageMap, visitMap, startNode, wormCount);
                    }
                }
            }

            int answer = 0;
            for(int j = 0; j < cabbageMap.length; j++) {
                for(int k = 0; k < cabbageMap[i].length; k++) {
                    answer = Math.max(answer, cabbageMap[j][k]);
                }
            }

            System.out.println(answer);
        }
    }

    private static void bfs(int[][] cabbageMap, boolean[][] visitMap, int[] startNode, int wormCount) {
        Queue<int[]> que = new LinkedList<>();
        que.add(startNode);

        while(!que.isEmpty()) {
            int[] node = que.poll();

            for(int i = 0; i < search.length; i++) {
                int y = node[0] + search[i][0];
                int x = node[1] + search[i][1];

                if(y >= 0 && x >= 0 && y < cabbageMap.length && x < cabbageMap[0].length && cabbageMap[y][x] == 1 && !visitMap[y][x]) {
                    cabbageMap[y][x] = wormCount;
                    visitMap[y][x] = true;

                    que.add(new int[]{y, x});
                }
            }
        }
    }

    private static int[][] createCabbageMap() throws IOException {
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //가로길이M 세로길이N
        int[][] cabbageMap = new int[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cabbageMap[y][x] = 1;
        }

        return cabbageMap;
    }
}
