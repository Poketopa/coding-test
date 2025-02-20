
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] answer = new int[input];
        answer[answer.length-1] = 53;
        answer[0] = 1;
        answer[1] = 2;
        int temp = 52;
        for(int i=input-2;i>1;i--){
            answer[i] = temp;
            temp--;
        }
        System.out.println(input);
        for(int i : answer)System.out.print(i+ " ");

    }
}