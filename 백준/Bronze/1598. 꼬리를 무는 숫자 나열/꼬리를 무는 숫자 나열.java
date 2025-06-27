import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int column1 = ((start + 3) / 4);
        int column2 = ((end + 3) / 4);

        int row1 = ((start-1) % 4);
        int row2 = ((end - 1)%4);

        System.out.println(Math.abs(column1 - column2) + Math.abs(row2 - row1));
    }
}