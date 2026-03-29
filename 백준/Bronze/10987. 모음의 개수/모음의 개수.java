import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        int count = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == 'a'
            || input.charAt(i) == 'e'
            || input.charAt(i) == 'i'
            || input.charAt(i) == 'o'
            || input.charAt(i) == 'u') count++;
        }
        System.out.print(count);
    }
}
