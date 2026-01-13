import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[][] number = new int[row][column];

        for(int i=0;i<row;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<column;j++){
                number[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int standard = Integer.parseInt(br.readLine());

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<row-2;i++){
            for(int j=0;j<column-2;j++){
                list.clear();
                list.add(number[i][j]);
                list.add(number[i][j+1]);
                list.add(number[i][j+2]);
                list.add(number[i+1][j]);
                list.add(number[i+1][j+1]);
                list.add(number[i+1][j+2]);
                list.add(number[i+2][j]);
                list.add(number[i+2][j+1]);
                list.add(number[i+2][j+2]);
                Collections.sort(list);
                if(list.get(4) >= standard){
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}
