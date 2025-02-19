
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            System.out.println(String.valueOf(temp.charAt(0))+String.valueOf(temp.charAt(temp.length()-1)));
        }
    }
}