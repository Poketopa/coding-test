import java.io.*;
import java.util.*;

public class Main {
    static long pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());


        while(true){
            int count = 0;
            String input = br.readLine();
            if(input.equals("#")) return;
            for(int i=0;i<input.length();i++){
                if(input.charAt(i) == 'a' ||
                        input.charAt(i) == 'e' ||
                        input.charAt(i) == 'i' ||
                        input.charAt(i) == 'o' ||
                        input.charAt(i) == 'u' ||
                        input.charAt(i) == 'A' ||
                        input.charAt(i) == 'E' ||
                        input.charAt(i) == 'I' ||
                        input.charAt(i) == 'O' ||
                        input.charAt(i) == 'U') count++;
            }
            System.out.println(count);
        }


    }
}
