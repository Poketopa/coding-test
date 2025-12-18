import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int team = Integer.parseInt(st.nextToken());

        int[] height = new int[people];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<people;i++) height[i] = Integer.parseInt(st2.nextToken());
        List<Integer> difference = new ArrayList<>();
        for(int i=0;i<people-1;i++) {
            difference.add(height[i+1] - height[i]);
        }
        Collections.sort(difference);
        int sum = 0;
        for(int i=0;i<people-team;i++) sum += difference.get(i);
        System.out.print(sum);
    }
}
