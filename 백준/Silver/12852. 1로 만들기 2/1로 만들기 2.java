import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{input, 0});

        int[] visited = new int[input + 1];

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int num = temp[0];
            if(num == 1){ // 찾음
                System.out.println(temp[1]);
                List<Integer> list = new ArrayList<>();
                list.add(1);
                while(true){
                    num = visited[num];
                    if(num == 0){
                        for(int i=0;i<list.size();i++){
                            System.out.print(list.get(list.size()-1-i) + " ");
                        }
                        return;
                    }
                    list.add(num);
                }
            }
            if(num % 3 == 0 && visited[num / 3] == 0){
                    visited[num / 3] = num;
                    queue.add(new int[]{num / 3, temp[1] + 1});
            }
            if(num % 2 == 0 && visited[num / 2] == 0){
                    visited[num / 2] = num;
                    queue.add(new int[]{num / 2, temp[1] + 1});
            }
            if(num > 1) {
                if(visited[num-1] != 0) continue;
                else{
                    visited[num-1] = num;
                    queue.add(new int[]{num-1, temp[1] + 1});
                }
            }
        }
    }
}
