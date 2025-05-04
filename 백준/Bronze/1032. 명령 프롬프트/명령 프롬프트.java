import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        String[] arr = new String[input];
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            arr[i] = temp;
        }
        String answer = "";
        x :for(int i=0;i<arr[0].length();i++){
            char temp = arr[0].charAt(i);
            for(int j=0;j<arr.length;j++){
                if(temp != arr[j].charAt(i)){
                    answer += '?';
                    continue x;
                }
            }
            answer += temp;
        }
        System.out.println(answer);
    }
}
