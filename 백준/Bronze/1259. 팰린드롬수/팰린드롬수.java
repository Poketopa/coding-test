import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        x:
        while(true){
            String input = br.readLine();
            if(input.equals("0")) return;
            for(int i=0;i<input.length()/2;i++){
                if(input.charAt(i) != input.charAt(input.length()-1-i)) {
                    System.out.println("no");
                    continue x;
                }
            }
            System.out.println("yes");
        }

    }
}