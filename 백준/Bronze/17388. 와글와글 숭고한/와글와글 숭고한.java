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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        map.put(a, "Soongsil");
        map.put(b, "Korea");
        map.put(c, "Hanyang");
        if(a+b+c >= 100){
            System.out.println("OK");
        } else {
            System.out.print(map.get(Math.min(a, Math.min(b, c))));
        }
    }

}
