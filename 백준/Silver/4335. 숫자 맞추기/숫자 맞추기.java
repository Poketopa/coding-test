import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());


        x: while(true){
            List<int[]> list = new ArrayList<>();
            int answer = 0;
            boolean lieFlag = false;
            while(true){
                int input = Integer.parseInt(br.readLine());
                if(input == 0) break x;
                String message = br.readLine();

                if(message.equals("too high")) list.add(new int[]{input, 1});
                else if(message.equals("too low")) list.add(new int[]{input, -1});
                else {
                    answer = input;
                    break;
                }
            }
            for(int[] temp : list){
                if(temp[0] > answer && temp[1] == -1
                        || temp[0] < answer && temp[1] == 1) lieFlag = true;
                if(temp[0] == answer && temp[1] != 0) lieFlag = true;
            }

            if(lieFlag) System.out.println("Stan is dishonest");
            else System.out.println("Stan may be honest");
        }
    }
}
