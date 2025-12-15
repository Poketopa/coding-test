import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=start;i<=end;i++) {
            list.add(i);
        }
        for(int i=start;i<=end;i++){
            if(i < 10){
                String one = getEnglish(i);
                map.put(i, one);
            }
            else{
                String one = getEnglish(i % 10);
                int temp = i / 10;
                String ten = getEnglish(temp);
                map.put(i, ten + one);
            }
        }

        Collections.sort(list, Comparator.comparing(map::get));

        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
            if(i % 10 == 9) System.out.println("");
        }
    }

    public static String getEnglish(int number){
        if(number == 0) return "zero";
        if(number == 1) return "one";
        if(number == 2) return "two";
        if(number == 3) return "three";
        if(number == 4) return "four";
        if(number == 5) return "five";
        if(number == 6) return "six";
        if(number == 7) return "seven";
        if(number == 8) return "eight";
        if(number == 9) return "nine";
        return "";
    }
}
