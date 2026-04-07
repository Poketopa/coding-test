import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int depth = Integer.parseInt(br.readLine());
        int input = (int)Math.pow(2, depth) - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++) list.add(Integer.parseInt(st.nextToken()));
        Queue<int[]> queue = new LinkedList<>();
        int start = input / 2;
        int startLength = (start + 1) / 2;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.get(start));
        stringBuilder.append("\n");

        queue.add(new int[]{start, startLength});

        for(int i=0;i<depth-1;i++){
            int queueSize = queue.size();
            for(int k=0;k<queueSize;k++){
                int[] temp = queue.poll();
                int now = temp[0];
                int length = temp[1];

                stringBuilder.append(list.get(now - length));
                stringBuilder.append(" ");
                stringBuilder.append(list.get(now + length));
                stringBuilder.append(" ");
                queue.add(new int[]{now - length, length / 2});
                queue.add(new int[]{now + length, length / 2});
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());
    }
}
