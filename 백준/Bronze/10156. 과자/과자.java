import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int quantity = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        
        if(price * quantity <= money){
            System.out.print("0");
            return;
        }
        System.out.println(price * quantity - money);

    }
}
