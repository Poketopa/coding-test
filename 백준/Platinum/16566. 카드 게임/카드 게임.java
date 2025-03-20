

import java.io.*;
import java.util.*;

public class Main {
    static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] myCard = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) myCard[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(myCard);
        int[] yourCard = new int[K];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) yourCard[i] = Integer.parseInt(st3.nextToken());
        int[] visited = new int[M];

        for(int i=0;i<K;i++){
            int temp = yourCard[i];
            System.out.println(binarySearch(0, M-1, temp, myCard, visited));
        }

    }
    private static int binarySearch(int start, int end, int target, int[] myCard, int[] visited){
        int mid = 0;

        while(start <= end){
            mid = (start + end) / 2;
            if(myCard[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        while(visited[start] == 1) start++;
        int result = myCard[start];
        visited[start] = 1;
        return result;
    }
}
