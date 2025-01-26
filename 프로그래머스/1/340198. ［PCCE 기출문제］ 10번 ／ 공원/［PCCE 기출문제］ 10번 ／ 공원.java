import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 가장 큰 매트 크기부터 확인
        Arrays.sort(mats);
        for(int length = mats.length-1;length>=0;length--){
            // 공원의 세로 길이
            for(int i=0;i<park.length;i++){
                // 공원의 가로 길이
                x : for(int j=0;j<park[0].length;j++){
                        // 탐색 시작 부분이 -1이 아니면 continue
                        if(!park[i][j].equals("-1")) continue;
                        // 매트 크기가 1일 때 리턴
                        if(mats[length] == 1) return 1;
                        // 매트 크기가 공원 범위 넘어가면 continue
                        if(i+mats[length] > park.length || j+mats[length]> park[0].length) continue;
                        // 매트 크기만큼 2차원배열 확인
                        for(int y = i;y<i+mats[length];y++){
                            for(int x = j;x<j+mats[length];x++){
                                if(!park[y][x].equals("-1")) continue x;
                            }
                        }
                        // 통과하면 return
                        return mats[length];
                }
            }
        }
        return -1;
    }
}