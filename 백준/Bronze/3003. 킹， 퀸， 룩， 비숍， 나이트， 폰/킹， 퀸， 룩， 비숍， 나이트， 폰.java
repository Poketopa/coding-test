
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] chess = new int[6];
        for(int i=0;i<chess.length;i++) chess[i] = Integer.valueOf(st.nextToken());

        int[] dong = new int[6];

        dong[0] = -(chess[0] - 1);
        dong[1] = -(chess[1] - 1);
        dong[2] = -(chess[2] - 2);
        dong[3] = -(chess[3] - 2);
        dong[4] = -(chess[4] - 2);
        dong[5] = -(chess[5] - 8);

        for(int i=0;i<6;i++){
            System.out.print(dong[i]+ " ");
        }

    }
}
