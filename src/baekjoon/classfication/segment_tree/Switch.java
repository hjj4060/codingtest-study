package baekjoon.classfication.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1395
public class Switch {
    static FastReader scan = new FastReader();
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static int tree[];
    static int leafCounter = 1;
    static int leafPointer = 0;

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        initTree();

        for (int i = 0; i < M; i++) {
            int button = scan.nextInt();
            int left = scan.nextInt();
            int right = scan.nextInt();

            if(button == 0) {
                reverse(left, right);
            } else {
                count(left, right);
            }
        }

        System.out.println(sb.toString());
    }

    private static void reverse(int left, int right) {
        int reverseLeft = left + leafPointer;
        int reverseRight = right + leafPointer;

        for (int i = reverseLeft; i <= reverseRight; i++) {
            if (tree[i] == 1) {
                tree[i] = 0;
            } else {
                tree[i] = 1;
            }
        }

        if(reverseLeft % 2 == 1) reverseLeft--;
        if(reverseRight % 2 == 0) reverseRight++;

        while(reverseLeft > 1) {
            for (int i = reverseLeft; i <= reverseRight; i+=2) {
                tree[i / 2] = tree[(i / 2) * 2] + tree[((i / 2) * 2) + 1];
            }

            reverseLeft /= 2;
            reverseRight /= 2;
        }
    }

    private static void count(int left, int right) {
        left += leafPointer;
        right += leafPointer;
        int cnt = 0;

        while(left <= right) {
            if (left % 2 == 1) {
                cnt += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                cnt += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        sb.append(cnt + "\n");
    }

    private static void initTree() {
        while(N > leafCounter) {
            leafCounter <<= 1;
        }

        leafPointer = leafCounter - 1;

        tree = new int[leafCounter * 2];
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if(st==null || !st.hasMoreElements()) {
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
