
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        int min = Integer.MAX_VALUE;

        // 2곱하기 or 10곱하기 + 1
        long number = start;
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{number, 0});

        while(!queue.isEmpty()){
            long[] temp = queue.poll();
            // 정답 발견
            if(temp[0] == target){
                min = Math.min(min, (int)temp[1]);
                continue;
            } // 곱하기 2
            if(temp[0] * 2 <= target){
                queue.add(new long[]{temp[0] * 2, temp[1] + 1});
            } // 오른쪽에 1 추가
            if((temp[0] * 10) + 1 <= target){
                queue.add(new long[]{temp[0]*10 + 1, temp[1]+1});
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min+1);
    }
}