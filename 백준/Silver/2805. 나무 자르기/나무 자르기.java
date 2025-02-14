
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int trees = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());
        int[] length = new int[trees];
        int max = -1;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<length.length;i++){
            length[i] = Integer.valueOf(st2.nextToken());
            max = Math.max(max, length[i]);
        }
        int start = 0;
        int end = max;
        int answer = 0;
        while(start<=end){
            int mid = (start + end) / 2;
            long sum = 0;
            for(int i=0;i<length.length;i++){
                // 나무가 작으면 안잘림
                if(mid >= length[i]) continue;
                sum += length[i] - mid;
            }
            if(sum == need){
                System.out.println(mid);
                return;
            }
            else if(sum > need){
                answer = mid;
                start = mid + 1;
            }
            else{
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(start-1);
    }
}