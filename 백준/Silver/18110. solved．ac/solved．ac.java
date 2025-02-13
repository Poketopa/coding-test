
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++){
            number[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(number);
        double no = input * 0.15;
        int noInt = 0;
        if(no % 1 <0.5) noInt = (int)no;
        else noInt = (int)(no+1);

        int sum = 0;
        for(int i=noInt;i<number.length-noInt;i++){
            sum+=number[i];
        }
        double result = (double)sum / (number.length - (2 * noInt));
        if(result%1<0.5) System.out.println((int)result);
        else System.out.println((int)(result+1));
    }
}