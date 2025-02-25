
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(cal(a, b, c));
    }

    private static long cal(long a, long b, long c){
        if(b == 1){
            return a % c;
        }

        long half = cal(a, b/2, c);

        if(b % 2 == 1){
            return (((half * half) % c) * a) % c;
        }
        else{
            return (half * half) % c;
        }
    }
}