import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(br.readLine());


        for(int k=0;k<testCase;k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int circle = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i=0;i<circle;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int circleX = Integer.parseInt(st2.nextToken());
                int circleY = Integer.parseInt(st2.nextToken());
                int r = Integer.parseInt(st2.nextToken());
                boolean startIn = isInCircle(startX, startY, circleX, circleY, r);
                boolean endIn = isInCircle(endX, endY, circleX, circleY, r);
                if(startIn ^ endIn){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
    public static boolean isInCircle(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
        // 제곱근을 계산하지 않아도 비교할 수 있도록 거리의 제곱을 비교
    }
}