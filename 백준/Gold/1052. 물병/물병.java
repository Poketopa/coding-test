import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int water = Integer.parseInt(st.nextToken());
        int bottle = Integer.parseInt(st.nextToken());

        while(true){
            int maxWater = makeMaxWater(water);
            water -= maxWater;
            bottle--;
            if(bottle == 0){
                if(water <= bottle){
                    System.out.print("0");
                } else {
                    System.out.print(maxWater - water);
                }
                break;
            }
        }
    }

    public static int makeMaxWater(int water){
        int temp = 2;
        while(true){
            if(temp * 2 > water) break;
            temp *= 2;
        }

        return temp;
    }
}
