

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<num1;i++) map.put(br.readLine(), true);
        for(int i=0;i<num2;i++) if(map.containsKey(br.readLine())) count++;
        System.out.println(count);
    }
}