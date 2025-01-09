import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] map = new int[park.length][park[0].length()];
        int x = 0;
        int y = 0;
        // 맵 생성
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                if(park[i].charAt(j) == 'S'){
                    y = i;
                    x = j;
                    map[i][j] = 0;
                }
                else if(park[i].charAt(j) == 'X'){
                    map[i][j] = 1;
                }
            }
        }
        x:
        for(int i=0;i<routes.length;i++){
            String[] move = routes[i].split(" ");
            int temp = Integer.valueOf(move[1]);
            if(move[0].equals("E")){
                if(x+temp<map[0].length){
                    for(int j=1;j<=temp;j++){
                        if(map[y][x+j] == 1) continue x;
                    }
                    x += temp;
                }
            }
            else if(move[0].equals("S")){
                if(y+temp<map.length){
                    for(int j=1;j<=temp;j++){
                        if(map[y+j][x] == 1) continue x;
                    }
                    y += temp;
                }
            }
            else if(move[0].equals("W")){
                if(x-temp>=0){
                    for(int j=1;j<=temp;j++){
                        if(map[y][x-j] == 1) continue x;
                    }
                    x -= temp;
                }
            }
            else if(move[0].equals("N")){
                if(y-temp>=0){
                    for(int j=1;j<=temp;j++){
                        if(map[y-j][x] == 1) continue x;
                    }
                    y -= temp;
                }
            }
        }
        return new int[]{y, x};
    }
}