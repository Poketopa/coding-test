
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder(br.readLine());
        StringBuilder target = new StringBuilder();
        for(int i=0;i<n;i++) target.append("IO");
        target.append("I");
        String answer = target.toString();

        int index = 0;
        int result = 0;
        while(index<=str.length()-answer.length())
        {
            int count = 0;
            if(str.charAt(index) == 'I'){
                index++;
                while(index < (str.length()-1) &&str.charAt(index) == 'O' && str.charAt(index+1) == 'I'){
                    count++;
                    index+=2;
                }
                if(count >= n){
                    result += count-n + 1;
                }
            }
            else index++;
        }
        System.out.println(result);
    }
}