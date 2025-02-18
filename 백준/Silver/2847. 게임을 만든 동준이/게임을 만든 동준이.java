
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] num = new int[input];

        for(int i=0;i<input;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        // 크기가 1일 때
        if(num.length == 0) System.out.println("0");

        int count = 0;
        for(int i=input-2;i>=0;i--){
            while(num[i] >= num[i+1]){
                num[i]--;
                count++;
            }
        }

        System.out.println(count);

    }
}