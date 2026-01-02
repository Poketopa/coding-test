import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=1;i<=input;i++){
            if(i < 10){
                sum += 1;
            }
            else if(i<100){
                sum += 2;
            }
            else if(i<1000){
                sum += 3;
            }
            else if(i<10000){
                sum += 4;
            }
            else if(i<100000){
                sum += 5;
            }
            else if(i<1000000){
                sum += 6;
            }
            else if(i<10000000){
                sum += 7;
            }
            else if(i<100000000){
                sum += 8;
            }
            else if(i<1000000000){
                sum += 9;
            }
        }
        System.out.print(sum);
    }
}
