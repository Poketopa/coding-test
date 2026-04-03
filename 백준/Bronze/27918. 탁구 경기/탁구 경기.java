import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        for(int i=0;i<input;i++){
            if(br.readLine().equals("D")) a++;
            else b++;
            
            if(Math.abs(a - b) >= 2) break;
        }
        System.out.print(a + ":" +b);
    }

}
