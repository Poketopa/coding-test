
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());
        int[] a = new int[aNum];
        int[] b = new int[bNum];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<aNum;i++) a[i] = Integer.parseInt(st2.nextToken());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<bNum;i++) b[i] = Integer.parseInt(st3.nextToken());
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : a) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i : b){
            if(map.containsKey(i)){
                if(map.get(i) > 0){
                    count++;
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        int answer = 0;
        if(aNum - count > 0) answer += aNum - count;
        if(bNum - count > 0) answer += bNum - count;
        System.out.println(answer);
    }
}