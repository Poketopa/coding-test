

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(br.readLine());
        for(int i=0;i<number;i++){
            int price = Integer.parseInt(br.readLine());
            int now = 0;
            int[] money = new int[4];
            while(price-now>0){
                if(price - now >= 25){
                    now += 25;
                    money[0]++;
                }
                else if(price - now >= 10){
                    now += 10;
                    money[1]++;
                }
                else if(price - now >= 5){
                    now+=5;
                    money[2]++;
                }
                else{
                    now++;
                    money[3]++;
                }
            }
            for(int j=0;j<4;j++){
                System.out.print(money[j]+" ");
            }
            System.out.println("");
        }

    }
}