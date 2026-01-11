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
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int div = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for(int i=0;i<length;i++){
            temp.add(list.get(i));

            if(i % (length / div) == (length / div) - 1){
                Collections.sort(temp);
                for(int j : temp) answer.add(j);
                temp.clear();
            }
        }
        for(int i : answer){
            System.out.print(i + " ");
        }

    }
}
