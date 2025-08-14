import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int a = 0;
        int b = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) a+=Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) b+=Integer.parseInt(st2.nextToken());
        System.out.print(Math.max(a,b));
    }
}
