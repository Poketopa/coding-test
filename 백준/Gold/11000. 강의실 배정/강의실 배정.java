import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->{
            return a - b;
        });
        for(int i=0;i<list.size();i++){
            if(queue.isEmpty()) {
                queue.add(list.get(i)[1]);
                continue;
            }
            if(queue.peek() <= list.get(i)[0]){
                queue.poll();
                queue.add(list.get(i)[1]);
            } else {
                queue.add(list.get(i)[1]);
            }
        }
        System.out.print(queue.size());
    }
}
