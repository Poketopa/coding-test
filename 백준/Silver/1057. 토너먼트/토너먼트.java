import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int player1 = Integer.parseInt(st.nextToken());
        int player2 = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        arr[player1 -1] = 1;
        arr[player2 - 1] = 1;
        int count = 1;
        Queue<Integer> queue1 = new LinkedList<>();
        for(int i : arr) queue1.add(i);

        while(queue1.size()!=1){
            Queue<Integer> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()){
                if(queue1.size()==1){
                    queue2.add(queue1.poll());
                } else{
                    int a = queue1.poll();
                    int b = queue1.poll();
                    if(a+b == 0) queue2.add(0);
                    else if(a + b == 1) queue2.add(1);
                    else{
                        // 발견
                        System.out.println(count);
                        return;
                    }
                }
            }
            queue1.clear();
            queue1 = new LinkedList<>(queue2);
            count++;
        }
        System.out.println("-1");
    }
}
