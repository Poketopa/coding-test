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


        StringTokenizer st = new StringTokenizer(br.readLine());
        int joka = Integer.parseInt(st.nextToken());
        int snack = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<snack;i++) list.add(Integer.parseInt(st2.nextToken()));
        Collections.sort(list);

        binarySearch(list, 1, list.get(list.size()-1), joka);
    }

    public static void binarySearch(List<Integer> list, int start, int end, int joka){
        int mid = (start + end) / 2;
        if(start > end){
            System.out.print(start - 1);
            return;
        }
        if(mid == 0){
            System.out.print("0");
            return;
        }

        long snack = 0;
        int index = binaryIndexSearch(list, 0, list.size()-1, mid);
        for(int i=index;i<list.size();i++) snack += list.get(i) / mid;

        if(snack >= joka){
            binarySearch(list, mid + 1, end, joka);
        } else {
            binarySearch(list, start, mid - 1, joka);
        }
    }

    public static int binaryIndexSearch(List<Integer> list, int start, int end, int target){
        int mid = (start + end) / 2;
        if(start > end){
            return start;
        }

        if(list.get(mid) < target){
            return binaryIndexSearch(list, mid + 1, end, target);
        } else {
            return binaryIndexSearch(list, start, mid - 1, target);
        }
    }
}
