import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int sensor = Integer.parseInt(br.readLine());
        int hub = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] sensors = new Integer[sensor];
        for(int i=0;i<sensor;i++) sensors[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensors, Collections.reverseOrder());
        Integer[] diff = new Integer[sensor - 1];
        for(int i=0;i<diff.length;i++){
            diff[i] = sensors[i] - sensors[i+1];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        int sum = 0;
        for(int i=hub -1;i<diff.length;i++){
            sum += diff[i];
        }
        System.out.print(sum);
    }
}
