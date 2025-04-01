
import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);
        int sum = 0;
        for(int i=0;i<input;i++){
            for(int j=0;j<=i;j++){
                sum += number[j];
            }
        }
        System.out.println(sum);
    }
}