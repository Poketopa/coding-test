import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        String[] chess = new String[8];
        for(int i=0;i<8;i++){
            chess[i] = br.readLine();
            for(int j=0;j<8;j++){
                if((i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) && chess[i].charAt(j) == 'F'){

                    count++;
                }

            }
        }
        System.out.print(count);

    }
}
