

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            set.add(name);
            if(status.equals("enter")){
                map.put(name, 1);
            }
            else{
                map.put(name, 0);
            }
        }
        List<String> name = new ArrayList<>(set);
        Collections.sort(name, (a, b)->{
            return -a.compareTo(b);
        });
        for(int i=0;i<name.size();i++){
            if(map.get(name.get(i)) == 1) System.out.println(name.get(i));
        }
    }
}


