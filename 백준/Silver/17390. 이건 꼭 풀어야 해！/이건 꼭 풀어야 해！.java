import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        StringTokenizer st2= new StringTokenizer(br.readLine());
        list.add(0);
        for(int i=0;i<length;i++) list.add(Integer.parseInt(st2.nextToken()));
        Collections.sort(list);
        for(int i=1;i<=length;i++) list.set(i, list.get(i) + list.get(i-1));
        
        for(int i=0;i<question;i++){
            StringTokenizer st4= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st4.nextToken());
            int b = Integer.parseInt(st4.nextToken());
            System.out.println(list.get(b) - list.get(a - 1));
        }

    }
}
