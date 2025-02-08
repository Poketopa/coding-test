import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.valueOf(br.readLine());
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{input, 0});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == 1){
                System.out.println(temp[1]);
                break;
            }
            if(temp[0] % 3 == 0) queue.add(new int[]{temp[0]/3, temp[1]+1});
            if(temp[0] % 2 == 0) queue.add(new int[]{temp[0]/2, temp[1]+1});
            queue.add(new int[]{temp[0]-1, temp[1]+1});
        }
        return;
    }
}