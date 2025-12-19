import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] classes = new int[input][2];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->{
            return a - b;
        });
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes[i][0] = start;
            classes[i][1] = end;
        }
        Arrays.sort(classes, (a, b) -> {
            return a[0] - b[0];
        });
        for(int i=0;i<input;i++){
            if(i == 0){
                queue.add(classes[i][1]);
                continue;
            }
            if(classes[i][0] >= queue.peek()){
                queue.poll();
                queue.add(classes[i][1]);
            }
            else{
                queue.add(classes[i][1]);
            }
        }
        System.out.print(queue.size());
    }
}
