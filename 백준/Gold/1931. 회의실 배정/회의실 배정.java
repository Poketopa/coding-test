import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        List<long[]> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.valueOf(st.nextToken());
            long b = Integer.valueOf(st.nextToken());
            list.add(new long[]{a, b});
        }
        Collections.sort(list, (a, b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else{
                if(a[0]<b[0]) return -1;
                else if(a[0]>b[0]) return 1;
                else return 0;
            }
        });
        long now = 0;
        long count = 0;

        for(int i=0;i<list.size();i++){
            if(now>list.get(i)[0]) continue;
            now = list.get(i)[1];
            count++;
        }
        System.out.println(count);


    }
}