import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int answer = 1;
        int max = 1;
        int upnow = number[0];
        for(int i=1;i<input;i++){
            if(upnow <= number[i]){
                answer++;
                max = Math.max(answer, max);
            }
            else{
                answer = 1;
            }
            upnow = number[i];
        }
        answer = 1;
        int downnow = number[input - 1];
        for(int i=input-2;i>=0;i--){
            if(downnow<=number[i]){
                answer++;
                max = Math.max(answer, max);
            }
            else{
                answer = 1;
            }
            downnow = number[i];
        }

        System.out.println(max);
    }
}