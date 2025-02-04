import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.valueOf(st.nextToken());
        int repeat = Integer.valueOf(st.nextToken());

        int[] basket = new int[length+1];
        for(int i=0;i<basket.length;i++) basket[i] = i;

        for(int i=0;i<repeat;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st2.nextToken());
            int end = Integer.valueOf(st2.nextToken());
            for(int j =0 ;j<(end-start)/2 + 1;j++){
                int temp = basket[j+start];
                basket[j+start] = basket[end-j];
                basket[end-j] = temp;
            }


        }

        for(int i=1;i<basket.length;i++) System.out.print(basket[i] + " ");
    }
}
