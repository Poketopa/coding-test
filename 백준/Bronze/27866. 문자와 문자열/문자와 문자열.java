import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();

        int idx = Integer.valueOf(br.readLine());
        System.out.println(input.charAt(idx-1));
        return;
    }
}