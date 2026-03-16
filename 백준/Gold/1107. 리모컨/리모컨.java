import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String numInput = br.readLine();
        int number = Integer.parseInt(numInput);
        int input = Integer.parseInt(br.readLine());
        Set<Integer> numSet = new HashSet<>();

        if(input != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<input;i++) numSet.add(Integer.parseInt(st.nextToken()));
        }

        int bigNum = -9999999;
        x:for(int i=number;i<=1000000;i++){
            if(i == 0) {
                if (!numSet.contains(0)) {
                    bigNum = 0;
                    break;
                } else {
                    continue;
                }
            }
            int temp = i;
            while(temp > 0){
                if(numSet.contains(temp % 10)){
                    continue x;
                }
                temp /= 10;
            }
            bigNum = i;
            break;
        }

        int smallNum = -9999999;
        x:for(int i=number;i>=0;i--){
            int temp = i;
            while(temp > 0){
                if(numSet.contains(temp % 10)){
                    continue x;
                }
                temp /= 10;
            }
            if(i == 0 && numSet.contains(0)) break;
            smallNum = i;
            break;
        }
        int bigNumLength = (bigNum == 0) ? 1 : (int)(Math.log10(Math.abs(bigNum)) + 1);
        int smallNumLength = (smallNum == 0) ? 1 : (int)(Math.log10(Math.abs(smallNum)) + 1);

        int close = Math.min(Math.abs(number - bigNum) + bigNumLength, Math.abs(number - smallNum) + smallNumLength);
        int noButton = Math.abs(number - 100);
        System.out.print(Math.min(close, noButton));
    }
}
