import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            int number = Integer.parseInt(st.nextToken());
            if(number == -1) continue;
            list.add(number);
        }
        list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);

        postOrder(list, 0, input - 1);
    }

    public static void postOrder(List<Integer> list, int start, int end){
        if(start > end){
            return;
        }

        int mid = (start + end) / 2;

        postOrder(list, start, mid - 1);

        postOrder(list, mid + 1, end);

        System.out.print(list.get(mid) + " ");
    }
}
