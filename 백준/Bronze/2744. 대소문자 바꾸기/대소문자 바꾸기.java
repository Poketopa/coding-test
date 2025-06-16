import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        String answer = "";

        for(int i=0;i<input.length();i++){
            if('a' <= input.charAt(i) && input.charAt(i) <= 'z'){
                answer += (char) ('A' + input.charAt(i) - 'a');
            }
            else{
                answer += (char) ('a' + input.charAt(i) - 'A');
            }
        }
        System.out.println(answer);
    }
}