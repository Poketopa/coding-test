
import java.io.*;
import java.util.*;

public class Main {
    static int[] degree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        degree = new int[node + 1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st2.nextToken());
            int[] num = new int[length];
            for(int j=0;j<length;j++){
                num[j] = Integer.parseInt(st2.nextToken());
            }
            for(int j=1;j<length;j++){
                list[num[j-1]].add(num[j]);
                degree[num[j]]++;
            }
        }
        for(int i = 1;i<=node;i++){
            if(degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            answer.add(temp);
            count++;
            for(int i=0;i<list[temp].size();i++){
                degree[list[temp].get(i)]--;
                if(degree[list[temp].get(i)] == 0){
                    queue.add(list[temp].get(i));
                }
            }
        }

        if(count != node){
            System.out.println("0");
        }
        else{
            for(int i : answer){
                System.out.println(i);
            }
        }
    }
}
