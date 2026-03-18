import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++) list.add(Integer.parseInt(st2.nextToken()));
        Deque<int[]> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            while(!deque.isEmpty() && deque.peekLast()[0] >= list.get(i)){
                deque.pollLast();
            }
            while(!deque.isEmpty() && deque.peekFirst()[1] <= i - length){
                deque.pollFirst();
            }
            deque.addLast(new int[]{list.get(i), i});

            sb.append(deque.peekFirst()[0]).append(" ");
        }

        System.out.print(sb);
    }
}
