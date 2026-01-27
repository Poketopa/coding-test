import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] original = new int[length];
        int[] prefix = new int[length + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<length;i++) original[i] = Integer.parseInt(st2.nextToken());

        for(int i=0;i<count;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            int number = Integer.parseInt(st3.nextToken());
            prefix[start - 1] += number;
            prefix[end] -= number;
        }

        for(int i=1;i<length;i++){
            prefix[i] += prefix[i-1];
        }
        for(int i=0;i<length;i++) original[i] += prefix[i];

        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<length;i++) sb.append(original[i] + " ");
        System.out.print(sb.toString());
    }
}
