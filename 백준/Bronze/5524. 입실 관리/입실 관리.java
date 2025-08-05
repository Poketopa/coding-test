import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        for(int i=0;i<input;i++){
            String temp = br.readLine();
            System.out.println(temp.toLowerCase());
        }
    }
}
