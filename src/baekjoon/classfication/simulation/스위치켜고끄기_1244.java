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
            while (switchLocation <= switchCnt) {
                changeSwitch(switchLocation);
                switchLocation *= 2;
            }
        } else {
            //여자
            int leftIdx = switchLocation - 1;
            int rightIdx = switchLocation + 1;
            boolean chkChange = false;
            while (leftIdx >= 1 && rightIdx <= switchCnt) {
                if(switchStatus[leftIdx] == switchStatus[rightIdx]) {
                    chkChange = true;
                    changeSwitch(leftIdx);
                    changeSwitch(rightIdx);
                }

                leftIdx--;
                rightIdx++;
            }

            if(chkChange) {
                changeSwitch(switchLocation);
            }
        }
    }

    private static void changeSwitch(int changeSwitchLocation) {
        if(switchStatus[changeSwitchLocation] == 0) {
            switchStatus[changeSwitchLocation] = 1;
        } else {
            switchStatus[changeSwitchLocation] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        inputAndSolve();
        print();
    }

    private static void print() {
        for (int i = 1; i < switchStatus.length; i++) {
            System.out.print(switchStatus[i] + " ");
        }
    }
}
