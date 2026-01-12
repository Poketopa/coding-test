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

        int input = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;

        while(true){
            int index = findMaxIndex(list);
            if(index == 0){
                System.out.print(count);
                return;
            }
            list.set(index, list.get(index) -1);
            list.set(0, list.get(0) + 1);
            count++;
        }

    }

    private static int findMaxIndex(List<Integer> list){
        int value = Integer.MIN_VALUE;
        int index = 0;

        for(int i=0;i<list.size();i++){
            if(value <= list.get(i)){
                index = i;
                value = list.get(i);
            }
        }
        return index;
    }
}
