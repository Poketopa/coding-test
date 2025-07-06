import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i=0;i<input;i++) {
            int temp = Integer.parseInt(br.readLine());
            for(int j=0;j<temp;j++){
                list.add(count);
            }
            count++;
        }
        for(int i=0;i<question;i++){
            int temp = Integer.parseInt(br.readLine());
            System.out.println(list.get(temp));
        }
    }
}