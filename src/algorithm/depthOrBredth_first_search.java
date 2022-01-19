package algorithm;
import java.util.*;
import java.io.*;

/*
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
public class depthOrBredth_first_search {
    public static int[] visit;
    public static ArrayList<Integer>[] adjlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adjlist = new ArrayList[N+1];
        visit = new int[N+1];

        for(int i=1; i<N+1; i++)
            adjlist[i] = new ArrayList<Integer>();

        for(int i=1; i<M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjlist[from].add(to);
        }

//		for(int i=1; i<N+1; i++) {
//			for(int j=0; j<adjlist[i].size(); j++) {
//				System.out.print(i+" ");
//				System.out.println(adjlist[i].get(j));
//			}
//		}

        Arrays.fill(visit, 0);
        System.out.println("DFS 방문순서");
        dfs(start);

        System.out.println();
        System.out.println();

        Arrays.fill(visit, 0);
        System.out.println("BFS 방문순서");
        bfs(start);

    }

    public static void dfs(int start) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(start);
        visit[start]=1;

        while(!s.isEmpty()) {
            int now = s.pop();
            System.out.print(now+" ");

            for(int i=0; i<adjlist[now].size(); i++) {
                int next = adjlist[now].get(i);

                if(visit[next]==0) {
                    visit[next]=1;
                    s.add(next);
                }
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visit[start]=1;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now+" ");

            for(int i=0; i<adjlist[now].size(); i++) {
                int next = adjlist[now].get(i);

                if(visit[next]==0) {
                    visit[next]=1;
                    q.add(next);
                }
            }
        }
    }
}
