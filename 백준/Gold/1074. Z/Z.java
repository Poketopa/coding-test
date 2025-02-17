

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = (int)Math.pow(2,Integer.parseInt(st.nextToken()));
        int targetY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());

        zet(targetY, targetX, 0, input, 0, input);

    }

    public static void zet(int targetY, int targetX, int startY, int endY, int startX, int endX){
        for(int i=startY;i<endY;i+=(endY-startY)/2){
            for(int j=startX;j<endX;j+=(endX-startX)/2){
                if(!(startY <= targetY && targetY <= endY) || !(startX <= targetX && targetX <= endX)){
                    count += (int)Math.pow((endX-startX)/2, 2);
                    continue;
                }
                // 크기가 2인 정사각형이면
                if((endY-startY) == 2){
                    if(i==targetY && j==targetX){
                        System.out.println(count);
                        return;
                    }
                    count++;
                }
                else{
                    zet(targetY, targetX, i, i+(endY-startY)/2, j, j+(endX-startX)/2);
                }
            }
        }
    }
}