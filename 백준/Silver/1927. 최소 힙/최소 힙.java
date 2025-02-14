
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<input;i++){
            int temp = Integer.valueOf(br.readLine());
            if(temp == 0){
                if(queue.isEmpty()){
                    System.out.println("0");
                    continue;
                }
                else{
                    System.out.println(queue.poll());
                }
            }
            else{
                queue.add(temp);
            }
        }

    }
}