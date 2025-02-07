import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(st.nextToken());
        int length = Integer.valueOf(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            if(temp.length()>=length){
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        String[] word = new ArrayList<>(map.keySet()).toArray(new String[0]);
        Arrays.sort(word, (a, b)->{
           if(map.get(a)>map.get(b)) return -1;
           else if(map.get(a)<map.get(b)) return 1;
           else{
               if(a.length()>b.length()) return -1;
               else if(a.length()<b.length()) return 1;
               else{
                   return a.compareTo(b);
               }
           }
        });
        for (String w : word) {
            bw.write(w);
            bw.newLine(); // 개행 추가
        }

        bw.flush();
        bw.close();
    }
}