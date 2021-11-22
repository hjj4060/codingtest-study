package baekjoon.stepbystep.if_statement;

/*
    https://www.acmicpc.net/problem/2884
 */
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h=0, m=0;

        h = sc.nextInt();
        m = sc.nextInt();

        new AlarmClock().solve(h, m);
    }

    public void solve(int h, int m) {
        //m이 -이면 +60 해주고 h는 -1 , h가 -되면 +24
        m = m-45;

        if(m < 0) {
            m = m+60;
            h--;

            if(h<0) h=h+24;
        }
        System.out.println(h + " " + m);
    }
}
