
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int count = 0;

        int temp = 1;
        while((int)Math.pow(temp, 2) <= input){
            count++;
            temp++;
        }
        System.out.println(count);
    }
}