

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String[] str = new String[5];
        for(int i=0;i<5;i++) str[i] = br.readLine();
        int length = 0;
        for(int i=0;i<5;i++) if(length<str[i].length()) length = str[i].length();

        for(int i=0;i<length;i++){
            for(int j=0;j<5;j++){
                if(i<str[j].length()){
                    System.out.print(str[j].charAt(i));
                }
            }
        }






    }
}