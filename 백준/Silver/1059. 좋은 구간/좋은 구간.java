import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        int target = Integer.parseInt(br.readLine());
        int index = input-1;

        for(int i : number){
            if(i == target){
                System.out.println("0");
                return;
            }
        }

        int left = 0;
        int right = 1001;

        for(int i=0;i<input;i++){
            if(number[i] < target) left = Math.max(left, number[i]);
            if(number[i] > target) right = Math.min(right, number[i]);
        }

        int a = target - left;
        int b = right - target;

        int answer = a * b - 1;
        System.out.println(answer);
    }
}