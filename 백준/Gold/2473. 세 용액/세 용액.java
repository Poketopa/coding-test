
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for(int i=0;i<input;i++){
            int left = i + 1;
            int right = input-1;
            while(left < right){
                long temp = (long)number[left] + (long)number[right] + (long)number[i];
                if(Math.abs(temp) < min){
                    min = Math.abs(temp);
                    answer[0] = number[left];
                    answer[1] = number[right];
                    answer[2] = number[i];
                }
                if(temp >= 0) right--;
                else left++;
            }
        }
        Arrays.sort(answer);
        for(long i : answer) System.out.print(i + " ");
    }
}
