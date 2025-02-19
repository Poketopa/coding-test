

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int zin = Integer.parseInt(st.nextToken());
        String answer = "";
        while(number != 0){
            int temp = number % zin;
            if(temp>9){
                char alpha = 'A';
                alpha += (temp - 10);
                answer += String.valueOf(alpha);
            }
            else{
                answer += String.valueOf((number % zin));
            }
            number /= zin;
        }
        for(int i=answer.length()-1;i>=0;i--){
            System.out.print(answer.charAt(i));
        }
    }
}