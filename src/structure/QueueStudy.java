package structure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStudy {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1); // 1 넣음
        queue.offer(2); // 2넣음, 데이터가 잘 넣어지면 true 반환됨

        queue.poll(); // 2 꺼내짐
    }
}
