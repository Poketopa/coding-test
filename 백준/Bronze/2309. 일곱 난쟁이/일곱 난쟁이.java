import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        int[] number = new int[9];

        for(int i=0;i<9;i++){
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            number[i] = temp;
        }
        int one = 0;
        int two = 0;

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i==j) continue;

                if(number[i] + number[j] == sum - 100){
                    one = i;
                    two = j;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<9;i++){
            if(i == one || i == two) continue;
            list.add(number[i]);
        }

        Collections.sort(list);

        for(int i : list){
            System.out.println(i);
        }
    }
}
