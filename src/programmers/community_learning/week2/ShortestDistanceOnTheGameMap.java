package programmers.community_learning.week2;

import baekjoon.classfication.bfs.Tomato;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/1844 게임 맵 최단거리
public class ShortestDistanceOnTheGameMap {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(sol.solution(maps));
    }


    private static class Solution {
        static int dx[] = {1,0,-1,0};
        static int dy[] = {0,1,0,-1};
        static int gameMap[][];
        static boolean visit[][];
        static Queue<Node> q = new LinkedList<>();
        static int N, M;

        public int solution(int[][] maps) {
            N = maps.length;
            M = maps[0].length;
            gameMap = new int[N][M];

            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[i].length; j++) {
                    gameMap[i][j] = maps[i][j];
                }
            }
            
            visit = new boolean[N][M];
            q.add(new Node(0, 0));
            visit[0][0] = true;

            bfs();

            int answer = 0;

            if (gameMap[N - 1][M - 1] == 1) {
                answer = -1;
            } else {
                answer = gameMap[N - 1][M - 1];
            }

            return answer;
        }

        private void bfs() {
            Node n;

            while (!q.isEmpty()) {
                n = q.poll();

                for (int i = 0; i < dx.length; i++) {
                    int tx = n.x + dx[i];
                    int ty = n.y + dy[i];

                    if(tx<0 || ty <0 || tx>=N || ty>=M || gameMap[tx][ty] == 0 || visit[tx][ty]) continue;

                    q.add(new Node(tx, ty));
                    visit[tx][ty] = true;

                    gameMap[tx][ty] = gameMap[n.x][n.y] + 1;
                }
            }
        }

        private static class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
