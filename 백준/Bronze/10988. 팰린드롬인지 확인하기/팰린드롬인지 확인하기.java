
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String temp = br.readLine();

        for(int i=0;i<temp.length()/2;i++){
            if(temp.charAt(i) != temp.charAt(temp.length()-1-i)){
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}