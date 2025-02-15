
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][]map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer>[] list = new List[input];
        for(int i=0;i<input;i++) list[i] = new ArrayList<>();
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(map[i][j] == 1){
                    list[i].add(j);
                }
            }
        }
        int[][] answer = new int[input][input];
        // for문으로 리스트 확인
        for(int i=0;i<input;i++){
            int[] visited = new int[input];
            Queue<Integer> queue = new LinkedList<>();
            for(int j=0;j<list[i].size();j++){
                queue.add(list[i].get(j));
            }
            while(!queue.isEmpty()){
                int temp = queue.poll();
                answer[i][temp] = 1;
                for(int k=0;k<list[temp].size();k++){
                    if(visited[list[temp].get(k)]==1) continue;
                    visited[list[temp].get(k)]=1;
                    queue.add(list[temp].get(k));
                }
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println("");
        }
    }
}