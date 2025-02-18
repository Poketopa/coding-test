

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) list1.add(Integer.parseInt(st.nextToken()));
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) list2.add(Integer.parseInt(st2.nextToken()));

        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());

        int sum=0;
        for(int i=0;i<input;i++){
            sum+=list1.get(i) * list2.get(i);
        }

        System.out.println(sum);


    }
}