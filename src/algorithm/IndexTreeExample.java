package algorithm;


import java.util.*;
import java.io.*;

/*
input
N
value

8
1 2 3 4 5 6 7 8
 */


public class IndexTreeExample {
    private static int N;
    private static int[] tree, tmp;
    private static int leafCount=1, leafPoint=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tmp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<tmp.length; i++)
            tmp[i] = Integer.parseInt(st.nextToken());

        init();

        //test--------------------------------------------
        printTree();

        int a=2, b=5;
        System.out.printf("sum %d, %d : %d\n\n", a, b, sum(a, b));

        int index = 2, val = 10;
        update(index, val);

        printTree();
    }

    public static void printTree() {
        for(int i=1; i<=8; i*=2) {
            for(int j=i; j<i+i; j++) {
                System.out.print(tree[j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void update(int idx, int val) {
        int i = idx + leafPoint;

        tree[i] = val;
        i/=2;

        while(i>0) {
            tree[i] = tree[i*2] + tree[(i*2)+1];
            i/=2;
        }
    }

    public static long sum(int left, int right) {
        int R = right + leafPoint;
        int L = left + leafPoint;
        long rst = 0L;

        while(L<=R) {
            if(L%2==1) {
                rst+=tree[L];
                L++;
            }
            if(R%2==0) {
                rst+=tree[R];
                R--;
            }
            L/=2;
            R/=2;
        }

        return rst;
    }

    public static void init() {
        while(leafCount<N)
            leafCount<<=1;

        leafPoint = leafCount-1;
        tree = new int[leafCount*2];

        for(int i=1; i<=N; i++)
            tree[i+leafPoint] = tmp[i];

        for(int i=leafPoint; i>0; i--)
            tree[i] = tree[i*2] + tree[(i*2)+1];
    }
}
