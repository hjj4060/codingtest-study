package baekjoon.stepbystep.sgement_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2357
public class MinimumAndMaximum {
    static int minimumTree[];
    static int maximumTree[];

    static FastReader scan = new FastReader();
    static int N, M;
    static int arr[];

    static int leafCounter = 1;
    static int leafPointer = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = scan.nextInt();
        }

        initTree();

       /* for (int i = 0; i < minimumTree.length; i++) {
            System.out.print(minimumTree[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < maximumTree.length; i++) {
            System.out.print(maximumTree[i] + " ");
        }
*/
        for (int i = 0; i < M; i++) {
            minimumAndMaximum(scan.nextInt(), scan.nextInt());

            if (i != M - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
    static void minimumAndMaximum(int left, int right) {
        left += leafPointer;
        right += leafPointer;

        TreeSet<Integer> minarr = new TreeSet<>();
        TreeSet<Integer> maxarr = new TreeSet<>();

        while(left <= right) {
            if(left % 2 == 1) {
                minarr.add(minimumTree[left]);
                maxarr.add(maximumTree[left]);
                left++;
            }

            if (right % 2 == 0) {
                minarr.add(minimumTree[right]);
                maxarr.add(maximumTree[right]);
                right--;
            }

            left /= 2;
            right /= 2;
        }

        sb.append(minarr.first() + " " + maxarr.last());
    }

    static void initTree() {
        //leafCounter
        while(leafCounter <= N) {
            leafCounter <<= 1; //16
        }

        //leafPointer
        leafPointer = leafCounter - 1; //15

        initMinTree();
        initMaxTree();
    }

    static void initMinTree() {
        minimumTree = new int[leafCounter * 2];
        Arrays.fill(minimumTree, 1000000001);

        for (int i = 1; i <= N; i++) {
            minimumTree[i + leafPointer] = arr[i];
        }

        for (int i = leafPointer; i > 0; i--) {
            if(minimumTree[i * 2] > minimumTree[(i * 2) + 1]) {
                minimumTree[i] = minimumTree[(i * 2) + 1];
            } else if(minimumTree[i * 2] < minimumTree[(i * 2) + 1]) {
                minimumTree[i] = minimumTree[(i * 2)];
            } else {
                minimumTree[i] = minimumTree[(i * 2)];
            }
        }
    }

    static void initMaxTree() {
        maximumTree = new int[leafCounter * 2];

        for (int i = 1; i <= N; i++) {
            maximumTree[i + leafPointer] = arr[i];
        }

        for (int i = leafPointer; i > 0; i--) {
            if(maximumTree[i * 2] < maximumTree[(i * 2) + 1]) {
                maximumTree[i] = maximumTree[(i * 2) + 1];
            } else if(maximumTree[i * 2] > maximumTree[(i * 2) + 1]) {
                maximumTree[i] = maximumTree[(i * 2)];
            } else {
                maximumTree[i] = maximumTree[(i * 2)];
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
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
