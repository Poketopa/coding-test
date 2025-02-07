import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int myNumber = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<myNumber;i++){
            queue.add(Integer.valueOf(st.nextToken()));
        }
        Stack<Integer> stack = new Stack<>();
        int now = 1;

        while(true){
            // 줄에서 뺄 수 있으면
            if(!queue.isEmpty() && queue.peek() == now){
                if(now == myNumber){
                    break;
                }
                queue.poll();
                now++;
            }
            else if(!stack.isEmpty() && stack.peek() == now){
                if(now == myNumber){
                    break;
                }
                stack.pop();
                now++;
            }
            else{
                if(!queue.isEmpty()) stack.add(queue.poll());
                else if(queue.isEmpty()){
                    if(stack.peek() == now){
                        stack.pop();
                        now++;
                        continue;
                    }
                    System.out.println("Sad");
                    return;
                }

            }
        }
        System.out.println("Nice");
    }
}