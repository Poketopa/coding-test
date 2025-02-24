

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        int max = -1;
        long maxNum = 0;
        for(int i=0;i<input;i++){
            Long temp = Long.parseLong(br.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if(map.get(temp) >= max) {
                if(max == map.get(temp)){
                    if(temp<maxNum){
                        maxNum = temp;
                    }
                }
                else{
                    max = map.get(temp);
                    maxNum = temp;
                }

            }
        }
        System.out.println(maxNum);
    }
}