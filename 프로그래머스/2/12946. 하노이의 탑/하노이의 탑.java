import java.util.*;
class Solution {
    public static List<int[]> list = new ArrayList<>();
    public static void hanoi(int num,int from, int sub, int to){
        if(num==0) return;
        hanoi(num-1, from, to, sub);
        list.add(new int[]{from,to});
        hanoi(num-1,sub,from,to);
    }
    
    public int[][] solution(int n) {
        hanoi(n, 1,2,3);
        int[][] answer = list.toArray(new int[0][]);
        return answer;
    }
}