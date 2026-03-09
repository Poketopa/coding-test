import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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

        int input = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (a, b) -> {
            return b[1] - a[1];
        });

        int now = list.get(0)[1];
        for(int i=0;i<list.size();i++){
            int time = list.get(i)[1];
            if(now > time) now = time;
            now -= list.get(i)[0];
            if(now < 0){
                System.out.print("-1");
                return;
            }
        }
        System.out.print(now);
    }
}
