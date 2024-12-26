import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n+1][m+1];
        for(int[] i : puddles){
            map[i[1]][i[0]] = -1;
        }
        // 첫째줄에 숫자 넣기
        for(int i=1;i<=m;i++){
            if(map[1][i]==-1) break;
            map[1][i] = 1;
        }
        for(int i=1;i<=n;i++){
            if(map[i][1]==-1) break;
            map[i][1] = 1;
        }


        // 배열 돌면서 이동
        for(int i=2;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                // 웅덩이면 건너뛰기
                if(map[i][j]==-1){
                    continue;
                }
                // 웅덩이가 없으면 2개 더함
                else if(map[i-1][j]!=-1&&map[i][j-1]!=-1){
                    map[i][j] = map[i-1][j] + map[i][j-1];
                    if(map[i][j]>=1000000007){
                        map[i][j]%=1000000007;
                    }
                }
                // 웅덩이가 위에 있으면 왼쪽 계승
                else if(map[i-1][j]==-1&&map[i][j-1]!=-1){
                    map[i][j] = map[i][j-1];
                }
                // 웅덩이가 왼쪽에 있으면 위쪽 계승
                else if(map[i-1][j]!=-1&&map[i][j-1]==-1){
                    map[i][j] = map[i-1][j];
                }
                // 둘다 있으면? break;
                else{
                    continue;
                }
            }
        }
        return (int)map[n][m];
    }
}