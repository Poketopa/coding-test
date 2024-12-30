import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        // 시간 배열에 분으로 넣기
        for(int i=0;i<book_time.length;i++){
            for(int j=0;j<2;j++){
                String[] temp = book_time[i][j].split(":");
                int hour = Integer.valueOf(temp[0]);
                int minute = Integer.valueOf(temp[1]);
                time[i][j] = hour * 60 + minute;
                if(j==1){
                    time[i][j]+=10;
                }
            }
        }
        // 시간 순으로 정렬 (시작순)
        Arrays.sort(time, (a, b)->{
           if(a[0]<b[0]) return -1;
           else if (a[0]==b[0]) return 0;
           else return 1;
        });
        int max = -1;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<time.length;i++){
            int timeMinIndex = -1;
            int timeMin = 99999;
            int test = 0;
            // 비어있으면
            if(list.isEmpty()){
                list.add(time[i]);
            }
            // 이미 있으면 확인
            else{
                // 끝난 시간 있으면 들어감, 없으면 새로 넣음
                for(int j = 0;j<list.size();j++){
                    if(list.get(j)[1]<=time[i][0]){
                        test = 1;
                        if(timeMin>list.get(j)[1]){
                            timeMin = list.get(j)[1];
                            timeMinIndex = j;
                        }
                    }
                }
                if(test == 1) {
                    list.set(timeMinIndex, time[i]);
                    continue;
                }
                // 없으면 새로 넣음
                list.add(time[i]);
            }

            // 크기 확인, max
            if(list.size()>max) max = list.size();
        }
        return max;
    }
}