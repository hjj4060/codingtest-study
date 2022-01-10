package baekjoon.classfication.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Minimum {
    static FastReader scan = new FastReader();
    static int N, M;
    static int tree[];
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    static int leafCounter = 1;
    static int leafPointer = 0;

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[N + 1];

        for(int i=1; i<=N; i++) {
            arr[i] = scan.nextInt();
        }

        initTree();

        for(int i=0; i<M; i++) {
            sb.append(findMinimum(scan.nextInt(), scan.nextInt()));

            if (i != M - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int findMinimum(int left, int right) {
        left += leafPointer;
        right += leafPointer;

        TreeSet<Integer> treeSet = new TreeSet<>();

        while(left <= right) {
            if(left % 2 == 1) {
                treeSet.add(tree[left]);
                left++;
            }

            if (right % 2 == 0) {
                treeSet.add(tree[right]);
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return treeSet.first();
    }

    static void initTree() {
        while (N > leafCounter) {
            leafCounter <<= 1;
        }

        leafPointer = leafCounter - 1;

        tree = new int[leafCounter * 2];

        Arrays.fill(tree, 1000000001);

        for (int i = 1; i <= N; i++) {
            tree[i + leafPointer] = arr[i];
        }

        for (int i = leafPointer; i > 0; i--) {
            if (tree[i * 2] > tree[(i * 2) + 1]) {
                tree[i] = tree[(i * 2) + 1];
            } else if((tree[i * 2] < tree[(i * 2) + 1])) {
                tree[i] = tree[(i * 2)];
            } else {
                tree[i] = tree[(i * 2)];
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
