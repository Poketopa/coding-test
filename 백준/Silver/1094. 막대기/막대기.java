
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        int min = 64;
        int sum = 64;
        int count = 1;
        while(sum != input){
            min /= 2;
            if(sum - min > input){
                sum -= min;
            }
            else if( sum- min == input){
                break;
            }
            else{
                count++;
            }
        }
        System.out.println(count);
    }
}