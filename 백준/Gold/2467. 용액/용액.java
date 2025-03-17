
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = input-1;
        int maxLeft = 0;
        int maxRight = 0;
        int min = Integer.MAX_VALUE;
        while(left < right){
            if(min > Math.abs(number[left] + number[right])){
                maxLeft = number[left];
                maxRight = number[right];
                min = Math.abs(number[left] + number[right]);
            }
            if(Math.abs(number[left] + number[right - 1]) < Math.abs(number[left + 1] + number[right])){
                right--;
            }
            else left++;
        }
        System.out.println(maxLeft +" "+maxRight);
    }
}
