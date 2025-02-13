
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(st.nextToken());
        int num = Integer.valueOf(st.nextToken());

        int[] lan = new int[input];
        long max = -1;
        for(int i=0;i<input;i++){
            lan[i] = Integer.valueOf(br.readLine());
            if(lan[i] > max) max = lan[i];
        }

        long answer = binarySearch(lan, max, num);
        System.out.println(answer);
    }

    private static long binarySearch(int[] lan, long max, int num){
        long start = 1;
        long end = max;
        long answer = 0;
        while(start<=end){
            long mid = (start + end) / 2;
            int sum = 0;
            for(int i=0;i<lan.length;i++){
                sum += lan[i] / mid;
            }
            if(sum>=num) {
                answer = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return answer;
    }
}