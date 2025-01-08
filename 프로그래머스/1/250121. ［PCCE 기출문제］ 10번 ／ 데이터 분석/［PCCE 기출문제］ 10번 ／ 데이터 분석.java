import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int index = 0;
        if(sort_by.equals("code")){
            index = 0;
        }
        else if(sort_by.equals("date")){
            index = 1;
        }
        else if(sort_by.equals("maximum")){
            index = 2;
        }
        else{
            // remain
            index = 3;
        }
        int sortIndex = index;

        if(ext.equals("code")){
            index = 0;
        }
        else if(ext.equals("date")){
            index = 1;
        }
        else if(ext.equals("maximum")){
            index = 2;
        }
        else{
            // remain
            index = 3;
        }
        Arrays.sort(data, (a, b)->{
            if(a[sortIndex]<b[sortIndex]){
                return -1;
            }
            else if(a[sortIndex]>b[sortIndex]){
                return 1;
            }
            else return 0;
        });
        // 정렬 끝
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(data[i][index]<val_ext) count++;
        }
        int[][] answer = new int[count][4];
        int newIndex = 0;
        for(int i=0;i<data.length;i++){
            if(data[i][index]<val_ext){
                answer[newIndex][0] = data[i][0];
                answer[newIndex][1] = data[i][1];
                answer[newIndex][2] = data[i][2];
                answer[newIndex][3] = data[i][3];
                newIndex++;
            }
        }
        return answer;
    }
}