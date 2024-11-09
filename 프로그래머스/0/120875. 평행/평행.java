class Solution {
    public int solution(int[][] dots) {
        if(((double)dots[1][1]-dots[0][1])/(dots[1][0]-dots[0][0]) == (double)(dots[3][1]-dots[2][1])/(dots[3][0]-dots[2][0])){
            return 1;
        }
        else if(((double)dots[2][1]-dots[0][1])/(dots[2][0]-dots[0][0]) == (double)(dots[3][1]-dots[1][1])/(dots[3][0]-dots[1][0])){
            return 1;
        }
        else if(((double)dots[3][1]-dots[0][1])/(dots[3][0]-dots[0][0]) == (double)(dots[2][1]-dots[1][1])/(dots[2][0]-dots[1][0])){
            return 1;
        }
        else{
            return 0;
        }
    }
}