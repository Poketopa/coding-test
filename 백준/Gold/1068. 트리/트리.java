import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] node = new int[input];
        int[] son = new int[input];
        Arrays.fill(son, 0);
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++){
            node[i] = Integer.parseInt(st.nextToken());
            map.put(node[i], 1);
            if(node[i] != -1) son[node[i]]++;
        }

        int delete = Integer.parseInt(br.readLine());
        if(node[delete] != -1){
            son[node[delete]]--;
        }

        int count = 0;



        for(int i=0;i<input;i++){
            if(son[i] != 0) continue;
            if(i == delete) continue;
            int nodeNum = i;
            while(true){
                int parent = node[nodeNum];
                if(parent == -1){
                    count++;
                    break;
                }
                if(parent == delete) {
                    break;
                }
                nodeNum = parent;
            }
        }

        System.out.print(count);
    }
}
