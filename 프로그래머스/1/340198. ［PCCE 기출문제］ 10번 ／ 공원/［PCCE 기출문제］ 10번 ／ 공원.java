import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int[][] map = new int[park.length][park[0].length];
        int[] visited = new int[mats.length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(!park[i][j].equals("-1")) map[i][j] = 1;
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                for(int k=0;k<mats.length;k++){
                    if(visited[k] == 1) continue;
                    if(howBig(map, visited, i, j, mats[k])) visited[k] = 1;
                }
            }
        }
        for(int i=visited.length-1;i>=0;i--){
            if(visited[i] == 1) return mats[i];
        }
        return -1;
    }

    private boolean howBig(int[][] map, int[] visited, int y, int x, int size){
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(i==map.length||j==map[0].length) return false;
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }
}