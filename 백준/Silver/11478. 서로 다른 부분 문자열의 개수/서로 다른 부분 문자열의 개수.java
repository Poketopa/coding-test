
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        HashSet<String> set = new HashSet<>();
        int count = 1;
        for(int i=1;i<=input.length();i++){
            for(int j=0;j<=input.length()-i;j++){
                set.add(input.substring(j, j+i));
            }

        }
        System.out.println(set.size());
    }
}