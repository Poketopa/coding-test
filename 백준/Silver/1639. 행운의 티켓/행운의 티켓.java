import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        int[] number = new int[input.length()];
        for(int i=0;i<input.length();i++){
            number[i] = input.charAt(i) - '0';
        }

        int maxLength = 0;

        for(int i=0;i<number.length;i++){
            for(int j=2;j<=number.length;j+=2){
                if(i + j > number.length) continue;
                int leftSum = 0;
                for(int k=i;k<i+(j/2);k++){
                    leftSum += number[k];
                }
                int rightSum = 0;
                for(int k=i + (j/2);k<i+j;k++){
                    rightSum += number[k];
                }
                if(leftSum == rightSum){
                    maxLength = Math.max(maxLength, j);
                }
            }
        }
        System.out.print(maxLength);
    }
}
