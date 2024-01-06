package baekjoon.solvedac.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/9205
public class BJ9205_맥주마시면서걸어가기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        input();



    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        //testCase <= 50
        int testCase = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int convenienceStoreCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < convenienceStoreCount; i++) {
            st = new StringTokenizer(br.readLine());


        }
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int manhattenDistance(Node node) {
            int manhattenDistance = 0;
            return Math.abs(node.x - this.x) + Math.abs(node.y - this.y);
        }
    }
}
