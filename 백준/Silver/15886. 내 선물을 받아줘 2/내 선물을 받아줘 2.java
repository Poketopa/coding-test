import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        String[] arr = temp.split("");
        int count = 0;
        for(int i=0;i<input-1;i++){
            if(arr[i].equals("E") && arr[i + 1].equals("W")) count++;
        }

        System.out.print(count);
    }
}
