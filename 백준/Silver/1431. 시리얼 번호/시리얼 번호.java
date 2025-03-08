

import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        String[] str = new String[input];
        for(int i=0;i<input;i++){
            str[i] = br.readLine();
        }
        Arrays.sort(str, (a,b)->{
           if(a.length()<b.length()) return -1;
           else if(a.length()>b.length()) return 1;
           else{
               int sumA = 0;
               int sumB = 0;
               for(int i=0;i<a.length();i++){
                   if('0'<=a.charAt(i) && a.charAt(i) <= '9') sumA+=a.charAt(i) - '0';
                   if('0'<=b.charAt(i) && b.charAt(i) <= '9') sumB+=b.charAt(i) - '0';
               }
               if(sumA<sumB) return -1;
               else if(sumA>sumB) return 1;
               else{
                   return a.compareTo(b);
               }
           }
        });
        for(int i=0;i<input;i++) System.out.println(str[i]);
    }
}
