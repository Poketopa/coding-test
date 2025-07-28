import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int rotate = Integer.parseInt(st.nextToken());
        String[] test = br.readLine().split(",");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(test[i]);
        }

        for(int i=0;i<rotate;i++){
            for(int j=0;j<length-1;j++){
                arr[arr.length-1-j] -= arr[arr.length-2-j];
            }
        }

        for(int i=0;i<length-rotate;i++){
            if(i == length-rotate-1)System.out.print(arr[rotate+i]);
            else  System.out.print(arr[rotate+i] +",");
        }
    }
}
