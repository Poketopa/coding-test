class Solution {
    int index = 1;
    int[] xy = {0,0};
    public void up(int[][] snail, int[][] visited,int[] xy, int n){
        while (true){
            snail[xy[0]][xy[1]] = index;
            visited[xy[0]][xy[1]] = 1;
            index++;
            if(xy[0]>0&&xy[1]>0&&visited[xy[0]-1][xy[1]-1]==0){
                xy[0]--;
                xy[1]--;
            }
            else{
                xy[0]++;
                break;
            }
        }


    }
    public void straight(int[][] snail, int[][] visited,int[] xy,int n){
        while (true){
            snail[xy[0]][xy[1]] = index;
            visited[xy[0]][xy[1]] = 1;
            index++;
            if(xy[1]<visited[xy[0]].length-1&&visited[xy[0]][xy[1]+1]==0){
                xy[1]++;
            }
            else{
                xy[0]--;
                xy[1]--;
                break;
            }
        }
    }
    public void down(int[][] snail, int[][] visited,int[] xy,int n){
        while (true){
            snail[xy[0]][xy[1]] = index;
            visited[xy[0]][xy[1]] = 1;
            index++;
            if(xy[0]<n-1&&visited[xy[0]+1][xy[1]]==0){
                xy[0]++;
            }
            else{
                xy[1]++;
                break;
            }
        }
    }

    public int[] solution(int n) {
        if(n==1){
            return (new int[]{1});
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        int[][] snail = new int[n][];
        int[][] visited = new int[n][];
        // 달팽이, 방문했는지 선언
        // 0으로 초기화
        for(int i=0;i<n;i++){
            visited[i] = new int[i+1];
            snail[i] = new int[i+1];
        }
        int[] answer;
        while (true){
            // 갈 곳이 없으면 나감
            if(index>sum){
                answer = new int[index-1];
                break;
            }
            // 내려감
            down(snail,visited,xy,n);
            if(index>sum){
                answer = new int[index-1];
                break;
            }
            straight(snail,visited,xy,n);
            if(index>sum){
                answer = new int[index-1];
                break;
            }
            up(snail,visited,xy,n);
        }
        // 정답

        int num = 0;

        for(int i=0;i<snail.length;i++){
            // x갯수만큼
            for(int j=0;j<snail[i].length;j++){
                // y갯수만큼
                answer[num]=snail[i][j];
                num++;
            }
        }
        return answer;
    }
}