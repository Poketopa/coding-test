import java.io.*;
import java.util.*;

public class Main{
    static int count = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.valueOf(br.readLine());

        for(int i=0;i<length;i++){
            count = 0;
            int input = Integer.valueOf(br.readLine());

            int[] numbers = new int[]{1,2,3};
            int sum = 0;

            dfs(input, numbers, sum);
            System.out.println(count);
        }

    }

    private static void dfs(int input, int[] numbers, int sum){
        if(sum >= input){
            if(sum> input){
                return;
            }
            else{
                count++;
                return;
            }
        }

        for(int i=0;i<3;i++){
            dfs(input, numbers, sum + numbers[i]);
        }
    }
}