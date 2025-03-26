
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] num = new int[input];
        for(int i=0;i<input;i++) num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        double temp = input * 0.15;
        int temp2 = 0;
        if(temp % 1 >= 0.5) temp2 = (int)temp + 1;
        else temp2 = (int)temp;
        double avg = 0;
        for(int i=temp2;i<num.length-temp2;i++){
            avg += num[i];
        }
        avg /= num.length - 2 * temp2;
        if(avg % 1 >= 0.5) System.out.println((int)avg + 1);
        else System.out.println((int)avg);
        }
}