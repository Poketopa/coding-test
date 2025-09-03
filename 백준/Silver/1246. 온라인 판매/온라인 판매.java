import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int eggs = Integer.parseInt(st.nextToken());
        int customer = Integer.parseInt(st.nextToken());

        int[] arr = new int[customer];
        for(int i=0;i<customer;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long sum = -1;
        int index = 0;

        for(int i=0;i<customer;i++){


            if(sum < arr[i] * Math.min(eggs, (customer - i))){
                sum = arr[i] * Math.min(eggs, (customer - i));
                index = arr[i];
            }
        }

        System.out.print(index + " " + sum);
    }
}
