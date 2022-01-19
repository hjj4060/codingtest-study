package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/4963
public class NumberOfIslands {
    static FastReader scan = new FastReader();
    static int w, h;
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static int arr[][];
    static boolean visit[][];
    static Queue<Node> q = new LinkedList();
    static int result = 0;

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            w = scan.nextInt(); //너비
            h = scan.nextInt(); //높이

            if(w == 0 && h == 0) {
                break;
            } else {
                arr = new int[h][w];
                visit = new boolean[h][w];

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        arr[i][j] = scan.nextInt();
                    }
                }
                result = 0;

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (visit[i][j] == false && arr[i][j] == 1) {
                            BFS(i ,j);

                            result++;
                        }
                    }
                }

                sb.append(result + "\n");
            }
        }

        System.out.println(sb);
    }

    private static void BFS(int i, int j) {
        q.add(new Node(i, j));
        visit[i][j] = true;

        while(!q.isEmpty()) {
            Node node;
            node = q.poll();

            for(int k=0; k<dx.length; k++) {
                int x, y;

                x = node.x + dx[k];
                y = node.y + dy[k];

                if (x >= h || y >= w || x < 0 || y < 0 || arr[x][y] == 0 || visit[x][y]) {
                    continue;
                }

                q.add(new Node(x, y));
                visit[x][y] = true;
            }
        }
    }


    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

