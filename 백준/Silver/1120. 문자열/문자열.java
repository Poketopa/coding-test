import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<=b.length()-a.length();i++){
            int count = 0;
            for(int j=0;j<a.length();j++){
                if(a.charAt(j) != b.charAt(i+j)) count++;
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}