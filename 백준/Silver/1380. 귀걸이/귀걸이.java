import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 1;

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) return;
            String[] student = new String[input];
            for(int i=0;i<input;i++){
                student[i] = br.readLine();
            }
            Map<String, Integer> map = new HashMap<>();
            for(int i=0;i<(input * 2) -1;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st2.nextToken());
                String dummy = st2.nextToken();
                map.put(student[index-1], map.getOrDefault(student[index-1], 0) + 1);
            }
            for(int i=0;i<input;i++){
                if(map.get(student[i]) == 1){
                    System.out.println(count + " " + student[i]);
                    count++;
                    break;
                }
            }
        }

    }
}
