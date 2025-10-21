import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int repeat = Integer.parseInt(br.readLine());

        x : for(int k = 0;k<repeat;k++){
            String input = br.readLine();

            int index = 0;
            int count = 0;

            if('A' <= input.charAt(0) && input.charAt(0) <= 'F') count++;
            if(input.charAt(0) != 'A') index++;
            if(input.charAt(index) == 'A') count++;
            while(input.charAt(index) == 'A') {
                index++;
                if(index >= input.length()){
                    System.out.println("Good");
                    continue x;
                }
            }
            if(input.charAt(index) == 'F') count++;
            while(input.charAt(index) == 'F'){
                index++;
                if(index >= input.length()){
                    System.out.println("Good");
                    continue x;
                }
            }
            if(input.charAt(index) == 'C') count++;
            while(input.charAt(index) == 'C'){
                index++;
                if(index >= input.length()){

                    System.out.println("Infected!");
                    continue x;
                }
            }
            if('A' <= input.charAt(index) && input.charAt(index) <= 'F' && input.length() - index <= 1) count++;

            if(count == 5){
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }

    }
}






