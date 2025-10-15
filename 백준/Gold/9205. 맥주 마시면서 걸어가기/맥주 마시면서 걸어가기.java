import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Store {
    int y;
    int x;
    boolean start;
    boolean end;
    boolean visited;

    public Store(int y, int x, boolean start, boolean end, boolean visited) {
        this.y = y;
        this.x = x;
        this.start = start;
        this.end = end;
        this.visited = visited;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for(int repeat = 0; repeat < input; repeat++){
            int storeCount = Integer.parseInt(br.readLine());
            List<Store> list = new ArrayList<>();
            for(int location = 0; location < storeCount + 2; location++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Store store = new Store(y, x, false, false, false);
                if(location == 0) store.start = true;
                if(location == storeCount + 1) store.end = true;
                list.add(store);
            }

            Queue<Store> queue = new LinkedList<>();
            queue.add(list.get(0));
            list.get(0).visited = true;
            boolean flag = false;

            x: while(!queue.isEmpty()){
                Store store = queue.poll();
                if(store.end){
                    flag = true;
                    break x;
                }
                for(int i=0;i<list.size();i++){
                    Store compareStore = list.get(i);
                    // 같은거면 패스
                    if(store.x == compareStore.x && store.y == compareStore.y) continue;
                    int distance = 0;
                    distance += Math.abs(store.x - compareStore.x) + Math.abs(store.y - compareStore.y);
                    if(distance <= 1000 && !compareStore.visited){
                        queue.add(compareStore);
                        compareStore.visited = true;
                    }
                }
            }
            if(flag){
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}






