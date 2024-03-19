package programmers.coding_test;

import baekjoon.classfication.bfs.Tomato;

import java.util.LinkedList;
import java.util.Queue;

public class Socar1 {
    public static void main(String[] args) {
        String[][] map3d = {{"XXXXX", "OOSXO", "OOXOO"}, {"XEOOO", "OXXXO", "OOOOX"}};

        Solution sol = new Solution();
        System.out.println(sol.solution(map3d));
    }

    static private class Solution {
        static int dx[] = {-1, 1, 0, 0, 0, 0};
        static int dy[] = {0, 0, -1, 1, 0, 0};
        static int dz[] = {0, 0, 0, 0, -1, 1};

        static int x, y, z;
        static int map3d_int[][][];
        static boolean visit[][][];
        static Queue<Node> q = new LinkedList<>();

        public int solution(String[][] map3d) {
            int answer = 0;
            z = map3d.length;
            y = map3d[0].length;
            x = map3d[0][0].length();

            map3d_int = new int[z][y][x];
            visit = new boolean[z][y][x];

            Node start_node;
            Node end_node = null;

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        char c = map3d[i][j].charAt(k);

                        if (c == 'X') {
                            map3d_int[i][j][k] = -1;
                        } else if (c == 'O') {
                            map3d_int[i][j][k] = 0;
                        } else if (c == 'S') {
                            map3d_int[i][j][k] = 0;
                            start_node = new Node(k, j, i);
                            q.add(start_node);
                            visit[i][j][k] = true;
                        } else {
                            map3d_int[i][j][k] = 0;
                            end_node = new Node(k, j, i);
                        }
                    }
                }
            }

            /*for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        System.out.print( map3d_int[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println("--------");*/

            BFS();

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        System.out.print(map3d_int[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            int end_z = end_node.z;
            int end_y = end_node.y;
            int end_x = end_node.x;

            return map3d_int[end_z][end_y][end_x];
        }

        private static class Node {
            int x;
            int y;
            int z;

            public Node(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }

        private static void BFS () {
            Node n;

            while (!q.isEmpty()) {
                n = q.poll();

                for (int i = 0; i < dx.length; i++) {
                    int tx = n.x + dx[i];
                    int ty = n.y + dy[i];
                    int tz = n.z + dz[i];

                    if (tx < 0 || ty < 0 || tz < 0 || tx >= x || ty >= y || tz >= z || map3d_int[tz][ty][tx] == -1 || visit[tz][ty][tx])
                        continue;

                    q.add(new Node(tx, ty, tz));
                    visit[tz][ty][tx] = true;

                    map3d_int[tz][ty][tx] = map3d_int[n.z][n.y][n.x] + 1;
                }
            }
        }
    }
}