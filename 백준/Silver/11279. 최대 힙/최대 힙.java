
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
             if(a>b) return -1;
             else if(a<b) return 1;
             else return 0;
        });
        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0){
                queue.add(temp);
            }
            else{
                if(queue.isEmpty()) System.out.println("0");
                else{
                    System.out.println(queue.poll());
                }
            }
        }
    }
}