import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static String[][] map;
    static int input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-input));
    }
}






