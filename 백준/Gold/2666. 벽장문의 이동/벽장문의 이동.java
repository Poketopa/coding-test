import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    // [변경됨] record Node -> static class Node
    // Java 11 호환을 위해 일반 클래스로 변경했습니다.
    static class Node {
        int index;
        int[] door;
        int answer;

        public Node(int index, int[] door, int answer) {
            this.index = index;
            this.door = door;
            this.answer = answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int open1 = Integer.parseInt(st.nextToken()) - 1;
        int open2 = Integer.parseInt(st.nextToken()) - 1;
        int[] door = new int[input];
        Arrays.fill(door, 1);
        door[open1] = 0;
        door[open2] = 0;

        int inputTarget = Integer.parseInt(br.readLine());
        int[] target = new int[inputTarget];
        for (int i = 0; i < inputTarget; i++) {
            target[i] = Integer.parseInt(br.readLine()) - 1;
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, door, 0);
        queue.add(node);
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int index = temp.index; // class 필드에 직접 접근

            if (index == target.length) {
                min = Math.min(min, temp.answer);
                continue;
            }

            int now = target[index];
            int[] nowDoor = temp.door;
            int nowAnswer = temp.answer;

            if (nowDoor[now] == 0) {
                queue.add(new Node(index + 1, nowDoor, nowAnswer));
                continue;
            }
            int right = findRight(now, nowDoor);
            int left = findLeft(now, nowDoor);
            int[] newRightDoor = Arrays.copyOf(nowDoor, nowDoor.length);
            int[] newLeftDoor = Arrays.copyOf(nowDoor, nowDoor.length);

            if (right != -1) {
                newRightDoor[now] = 0;
                newRightDoor[now + right] = 1;
                queue.add(new Node(index + 1, newRightDoor, nowAnswer + right));
            }
            if (left != -1) {
                newLeftDoor[now] = 0;
                newLeftDoor[now - left] = 1;
                queue.add(new Node(index + 1, newLeftDoor, nowAnswer + left));
            }

        }

        System.out.print(min);
    }

    public static int findRight(int now, int[] door) {
        int count = 0;
        while (now < door.length && door[now] == 1) {
            count++;
            now++;
        }

        if (now >= door.length) {
            return -1;
        } else {
            return count;
        }
    }

    public static int findLeft(int now, int[] door) {
        int count = 0;
        while (now >= 0 && door[now] == 1) {
            count++;
            now--;
        }

        if (now <= -1) {
            return -1;
        } else {
            return count;
        }
    }
}