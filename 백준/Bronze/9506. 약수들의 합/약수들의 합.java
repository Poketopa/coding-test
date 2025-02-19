

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == -1) return;
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for(int i=1;i<input;i++){
                if(input % i == 0) {
                    sum+= i;
                    list.add(i);
                }
            }
            if(sum == input){
                System.out.print(input+" = ");
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+" + ");
                }
                System.out.println(list.get(list.size()-1));
            }
            else{
                System.out.println(input+" is NOT perfect.");
            }
        }
    }
}