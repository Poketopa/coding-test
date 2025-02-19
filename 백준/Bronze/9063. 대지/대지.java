
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int maxY = -1000000;
        int maxX = -1000000;
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            maxY = Math.max(maxY, y);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            minX = Math.min(minX, x);

        }
        System.out.println((maxY-minY) * (maxX-minX));
    }
}