import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        String[][] map = new String[column][row];
        for(int i=0;i<column;i++){
            map[i] = br.readLine().split("");
        }
        int max = -1;
        int size = Math.min(column, row);
        x:while(true){
            for(int i=0;i<column;i++){
                for(int j=0;j<row;j++){
                    if(i+size<column && j + size< row){
                        if(map[i][j].equals(map[i][j+size]) && map[i][j+size].equals(map[i+size][j+size]) && map[i][j].equals(map[i+size][j])){
                            max = (size + 1) * (size + 1);
                            break x;
                        }
                    }
                }
            }
            size--;
            if(size == 0) break;
        }

        if(max == -1) System.out.println("1");
        else System.out.println(max);

    }
}
