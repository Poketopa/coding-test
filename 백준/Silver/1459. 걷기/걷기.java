import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        if(W*2 <= S){ // 대각선이 더 느린 경우
            System.out.print((X + Y) * W);
        }
        else{
            long sum = 0;
            sum += (long) Math.min(X, Y) * S;
            if(W > S){
                if(Math.abs(Y - X) % 2 == 0){
                    sum += (long) Math.abs(Y - X) * S;
                    System.out.print(sum);
                }
                else{
                    sum += (long) (Math.abs(Y - X) - 1) * S;
                    sum += W;
                    System.out.print(sum);
                }
            }
            else{
                sum += (long) Math.abs(Y - X) * W;
                System.out.print(sum);
            }
        }
    }
}
