import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        while(index < input.length()){
            if(input.charAt(index) == '.') {
                sb.append(".");
                index++;
            }
            else if(input.length() - index >= 4
                    && input.charAt(index) == 'X'
                    && input.charAt(index+1) == 'X'
                    && input.charAt(index+2) == 'X'
                    && input.charAt(index+3) == 'X'){
                sb.append("AAAA");
                index+=4;
            }
            else if(input.length() - index >= 2
                    && input.charAt(index) == 'X'
                    && input.charAt(index+1) == 'X'){
                sb.append("BB");
                index+=2;
            }
            else {
                System.out.print("-1");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
