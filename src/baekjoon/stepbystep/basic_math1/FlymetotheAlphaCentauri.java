package baekjoon.stepbystep.basic_math1;

import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        long x, y, cnt;
        ArrayList<Long> result = new ArrayList<>();

        long move = 1; //이동거리
        long move_need = 0; //필요한 이동거리
        long moveable[] = new long[3]; //이동 가능한 거리

        for (int i = 0; i < T; i++) {
            cnt = 0;
            move = 1;
            move_need = 0;
            moveable[0] = 0;
            moveable[1] = 0;
            moveable[2] = 0;

            //1에서 5도착
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken()); //1
            y = Long.parseLong(st.nextToken()) - 1; //4

            //x -> y
            while(true) {
                x = x + move; //2
                cnt++; //1

                if (x == y) {
                    cnt++;
                    result.add(cnt);

                    break;
                } else {
                    moveable[0] = move - 1; //0
                    moveable[1] = move; //1
                    moveable[2] = move + 1; //2
                    move_need = y - x; //3

                    if (moveable[2] <= move_need) {
                        move = moveable[2];
                    } else if(moveable[1] <= move_need) {
                        move = moveable[1];
                    } else {
                        move = moveable[0];
                    }
                }
            }
        }

        for (long i:result) {
            System.out.println(i);
        }
    }
}
