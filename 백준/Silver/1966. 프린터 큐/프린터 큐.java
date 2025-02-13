import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        // 우선순위 배열 오름차순
        for(int l=0;l<input;l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.valueOf(st.nextToken());
            int index = Integer.valueOf(st.nextToken());
            int[] priority = new int[length];
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0;i<length;i++){
                priority[i] =Integer.valueOf(st2.nextToken());
                if(i == index) queue.add(new int[]{priority[i], 1});
                else queue.add(new int[]{priority[i], 0});
            }
            Arrays.sort(priority);
            int priIndex = priority.length-1;
            int count = 1;
            while(true){
                int[] temp = queue.poll();
                if(temp[0] == priority[priIndex]){
                    if(temp[1] == 1) {
                        System.out.println(count);
                        break;
                    }else{
                        priIndex--;
                        count++;
                    }
                }
                else{
                    queue.add(temp);
                }
            }
        }
    }
}