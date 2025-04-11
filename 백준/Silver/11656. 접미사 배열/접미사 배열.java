
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        List<String> list = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            list.add(input.substring(i));
        }
        Collections.sort(list);
        for(String i : list) System.out.println(i);
    }
}