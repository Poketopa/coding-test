
import java.io.*;
import java.util.*;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=a;i++) queue.add(i);

        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            for(int i=0;i<b-1;i++) queue.add(queue.poll());
            list.add(queue.poll());
        }
        System.out.print("<");
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1) System.out.print(list.get(i)+">");
            else System.out.print(list.get(i)+", ");
        }
    }
}