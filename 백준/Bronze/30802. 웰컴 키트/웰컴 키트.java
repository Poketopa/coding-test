import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int input = Integer.valueOf(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int shirt = Integer.valueOf(st2.nextToken());
        int pen = Integer.valueOf(st2.nextToken());

        for(int i=0;i<6;i++){
            sum += (arr[i] + shirt-1) / shirt;
        }
        System.out.println(sum);
        System.out.println((input) / pen + " " + input % pen);

    }
}
