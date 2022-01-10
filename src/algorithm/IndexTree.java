package algorithm;

public class IndexTree {
    static long tree[];
    static int leafCount = 1;
    static int leafPointer = 0;

    static int N = 4;


    public static void main(String[] args) {
        initTree();

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.print(sum(1,1));

        System.out.println();

        update(3, 10);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    static long sum(int left, int right) {
        int result = 0;
        left += leafPointer;
        right += leafPointer;

        while (left <= right) {
            if (left % 2 == 1) {
                result += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                result += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return result;
    }

    static void update(int index, int value) {
        int p = index + leafPointer; //10

        tree[p] = value;

        while (p > 0) {
            p /= 2;
            tree[p] = tree[p * 2] + tree[(p * 2) + 1];
        }
    }

    static void initTree() {
        //leafCounter
        while (leafCount < N) {
            leafCount <<= 1;
        }
        //leafPointer
        leafPointer = leafCount - 1;

        //tree 크기
        tree = new long[leafCount * 2];

        //tree 값
        for (int i = 1; i <= N; i++) {
            tree[leafPointer + i] = i;
        }

        for (int i = leafPointer; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[(i * 2) + 1];
        }
    }
}
