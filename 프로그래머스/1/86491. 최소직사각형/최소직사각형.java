class Solution {
    public int solution(int[][] sizes) {
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int xMax = -1;
        int yMax = -1;
        for(int i=0;i<sizes.length;i++){
            if(xMax < sizes[i][0]) xMax = sizes[i][0];
            if(yMax < sizes[i][1]) yMax = sizes[i][1];
        }
        return xMax * yMax;
    }
}