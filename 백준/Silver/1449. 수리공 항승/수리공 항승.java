import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arr);

        int index = 0;
        int start = 0;
        int count = 0;

        while(start < N){
            index = 0;
            while(arr[start + index] - arr[start] < L){
                index++;
                if(start + index >= N){
                    break;
                }
            }
            start += index;
            count++;
        }
        System.out.print(count);
    }
}
