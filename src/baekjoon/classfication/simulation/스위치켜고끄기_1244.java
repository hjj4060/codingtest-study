package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244 {
    static int switchCnt;
    static int[] switchStatus;

    private static void inputAndSolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        switchCnt = Integer.parseInt(st.nextToken());
        switchStatus = new int[switchCnt + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchLocation = Integer.parseInt(st.nextToken());

            solve(gender, switchLocation);
        }
    }

    private static void solve(int gender, int switchLocation) {
        if (gender == 1) {
            //남자
            int num = switchLocation;
            while (switchLocation <= switchCnt) {
                switchStatus[switchLocation] ^= 1;
                switchLocation += num;
            }
        } else {
            //여자
            int leftIdx = switchLocation - 1;
            int rightIdx = switchLocation + 1;
            while (leftIdx >= 1 && rightIdx <= switchCnt) {
                if(switchStatus[leftIdx] == switchStatus[rightIdx]) {
                    leftIdx--;
                    rightIdx++;
                } else {
                    break;
                }
            }

            leftIdx++;
            rightIdx--;

            for (int i = leftIdx; i <= rightIdx; i++) {
                switchStatus[i] ^= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < switchStatus.length; i++) {
            sb.append(switchStatus[i] + " ");

            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
    }
}
