
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
        String target = "";
        for(int i=0;i<n;i++) target += "IO";
        target += "I";

        int count = 0;
        for(int i=0;i<=str.length()-target.length();i++){
            if(str.substring(i, i+target.length()).equals(target)) count++;
        }
        System.out.println(count);
    }
}