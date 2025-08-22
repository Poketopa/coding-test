import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int fruit = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<fruit;i++){
            list.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(list);

        for(int i : list){
            if(i <= length){
                length++;
            }
            else break;
        }

        System.out.print(length);
    }
}
