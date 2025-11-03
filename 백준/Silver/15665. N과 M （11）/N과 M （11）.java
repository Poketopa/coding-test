import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberSize = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<numberSize;i++){
            set.add(Integer.parseInt(st2.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        List<Integer> numbers = new ArrayList<>();
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        dfs(list, numbers, 0, length, sb);
        System.out.print(sb.toString());
    }

    public static void dfs(List<Integer> list, List<Integer> numbers, int now, int length, StringBuilder sb){
        if(now == length){
            for(int i : numbers){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<list.size();i++){
            numbers.add(list.get(i));
            dfs(list,numbers, now + 1, length, sb);
            numbers.remove(numbers.size() - 1);
        }
    }
}






