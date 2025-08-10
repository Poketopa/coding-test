import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int count = input;

        queue.add(count);

        count--;

        for(int i=1;i<input;i++){
            queue.add(count);
            for(int j=i;j<input;j++){
                queue.add(queue.poll());
            }count--;
        }

        List<Integer> list = new ArrayList<>(queue);
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i) + " ");
        }
    }
}
