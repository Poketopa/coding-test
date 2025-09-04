import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[input + 1];
        for(int i=1;i<=input;i++) num[i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<=input;i++){
            int count = 1;
            for(int j=i;j<=input;j+=i){
                num[j] = Math.min(num[j], num[i] * count);
                count++;
            }
        }

        for(int i=1;i<=input;i++){
            for(int j=i+1;j<=input;j++){
                if(i + j >= num.length) continue;
                num[i + j] = Math.min(num[i + j] ,num[i] + num[j]);
            }
        }

        System.out.print(num[num.length-1]);
    }
}
