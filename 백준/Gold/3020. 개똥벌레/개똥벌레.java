import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        for(int i=0;i<number;i++){
            if(i % 2 == 0) down.add(Integer.parseInt(br.readLine()));
            else up.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(up);
        Collections.sort(down);
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1;i<=height;i++){
            int sum = 0;
            int downIndex = binarySearch(down, i, 0, down.size()-1);
            sum += down.size() - downIndex;
            int upIndex = binarySearch(up, height - i + 1, 0, up.size()-1);
            sum += up.size() - upIndex;
            min = Math.min(min, sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.print(min + " " + map.get(min));
    }

    public static int binarySearch(List<Integer> down, int target, int start, int end){
        if(start > end){
            return start;
        }
        int mid = (start + end) / 2;
        if(down.get(mid) < target){
            return binarySearch(down, target, mid + 1, end);
        }
        else{
            if(start == end){
                return start;
            }
            return binarySearch(down, target, start, mid);
        }
    }
}
