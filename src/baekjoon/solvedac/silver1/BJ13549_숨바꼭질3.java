package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13549
public class BJ13549_숨바꼭질3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    final static int[] search = new int[]{-1, 1, 2};
    final static int[] visitTimeLocation = new int[100001];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int startSubinLocation = Integer.parseInt(st.nextToken());
        int brotherLocation = Integer.parseInt(st.nextToken());

        if (startSubinLocation == brotherLocation) {
            System.out.println(visitTimeLocation[startSubinLocation]);
            return;
        }

        for (int i = 0; i < visitTimeLocation.length; i++) {
            visitTimeLocation[i] = Integer.MAX_VALUE;
        }

        visitTimeLocation[startSubinLocation] = 0;
        bfs(startSubinLocation);

        System.out.println(visitTimeLocation[brotherLocation]);
    }

    public static void bfs(int startSubinLocation) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add((new int[]{startSubinLocation, visitTimeLocation[startSubinLocation]}));

        while (!queue.isEmpty()) {
            int[] locationAndTime = queue.poll();

            for (int i = 0; i < search.length; i++) {
                int subinLocation = locationAndTime[0];
                int searchTime = locationAndTime[1];
                int movedSubinLocation = 0;

                if(i == 2) {
                    movedSubinLocation = subinLocation * search[i];
                } else {
                    movedSubinLocation = subinLocation + search[i];
                    searchTime = searchTime + 1;
                }

                if (movedSubinLocation >= 0 && movedSubinLocation <= 100000
                        && visitTimeLocation[movedSubinLocation] > searchTime) {
                    visitTimeLocation[movedSubinLocation] = searchTime ;

                    queue.add(new int[]{movedSubinLocation, visitTimeLocation[movedSubinLocation]});
                }
            }
        }
    }
}
