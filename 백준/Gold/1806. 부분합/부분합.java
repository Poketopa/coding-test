

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) num[i] = Integer.parseInt(st2.nextToken());
        int start = 0;
        int end = 0;
        int sum = num[0];
        int min = Integer.MAX_VALUE;
        while(true){
            if(sum < S){
                end++;
                if(end == N)break;
                sum += num[end];
            }
            else{
                if(start == end) {
                    System.out.println("1");
                    return;
                }
                min = Math.min(min, end - start + 1);
                sum -= num[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}
