package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1697
public class BJ1697_숨바꼭질 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    final static int[] search = new int[]{-1, 1, 2};
    final static int[] visitTime = new int[100001];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int startSubinLocation = Integer.parseInt(st.nextToken());
        int brotherLocation = Integer.parseInt(st.nextToken());

        if(startSubinLocation == brotherLocation) {
            System.out.println(visitTime[startSubinLocation]);
            return;
        }

        dfsMoveSubinLocation(startSubinLocation, brotherLocation);

        System.out.println(visitTime[brotherLocation]);
    }

    static void dfsMoveSubinLocation(int startSubinLocation, int brotherLocation) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startSubinLocation, visitTime[startSubinLocation]});

        while(!queue.isEmpty()) {
            int[] locationAndTime = queue.poll();
            int subinLocation = locationAndTime[0];
            int searchTime = locationAndTime[1] + 1;

            for(int i = 0; i < search.length; i++) {
                int movedSubinLocation = 0;

                if(i == 2) {
                    movedSubinLocation = subinLocation * search[i];
                } else {
                    movedSubinLocation = subinLocation + search[i];
                }

                if(movedSubinLocation >= 0 && movedSubinLocation <= 100000 && visitTime[movedSubinLocation] == 0 && movedSubinLocation != startSubinLocation) {
                    visitTime[movedSubinLocation] = searchTime;
                    queue.add(new int[]{movedSubinLocation, searchTime});

                    if(movedSubinLocation == brotherLocation) {
                        return;
                    }
                }
            }
        }
    }
}
