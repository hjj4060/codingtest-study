package algorithm;
import java.util.*;
import java.io.*;

/*
그래프 표현방식

그래프 문제에서 간선과 노드가 주어졌을때 프로그래밍으로 표현하는 방법
기본적으로 그래프 문제는 모든 정점을 방문하면서 최적의 해를 구하므로 문제에 따라 적절하게 사용한다

1. 행렬
가장 단순한 매트릭스로 표현한 방법 O(V^2)
2. 리스트
행렬의 시간복잡도를 줄인 방법 O(V+E)

input
Node, Edge, Start
from, to

7 6 1
1 2
1 3
2 4
2 5
3 6
3 7
 */

public class GraphExample {public static int[][] map;
    public static ArrayList<Integer>[] adjlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int strat = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        adjlist = new ArrayList[N+1];
        for(int i=1; i<N+1; i++)
            adjlist[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1; //매트릭스 양방향
            map[to][from] = 1;

            adjlist[from].add(to); //리스트 단방향
            //adjlist[to].add(from); //양방향일때
        }

        //map[1][2] = 1 → 갈수있다, if) 0이면 갈수없다
        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        //adjlist[1] = [2, 3] → 1에서 2, 3을 갈수있다
        for(int i=1; i<adjlist.length; i++) {
            System.out.println(adjlist[i]);
        }

    }

}
