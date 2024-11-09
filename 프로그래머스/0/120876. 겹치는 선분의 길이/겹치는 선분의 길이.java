class Solution {
    public int solution(int[][] lines) {
        int answer =0 ;
        for(float i=-100;i<100;i++){
            int count=0;
            for(int j=0;j<lines.length;j++){
                if(lines[j][0]<=i && i<lines[j][1]){
                    count++;
                }
            }
            if(count>1) answer++;
        }
        return answer;
    }
}