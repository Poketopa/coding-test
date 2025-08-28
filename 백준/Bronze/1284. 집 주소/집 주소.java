import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){
            String input = br.readLine();
            if(input.equals("0")) return;
            int sum = 0;
            for(int i=0;i<input.length();i++){
                if(input.charAt(i) == '1') sum += 2;
                else if(input.charAt(i) == '0') sum += 4;
                else sum += 3;
            }
            System.out.println(sum + (input.length()) + 1);
        }
    }
}
