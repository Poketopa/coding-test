class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = wallpaper[0].length();
        int startY = wallpaper.length;
        int endX = 0;
        int endY = 0;
        for (int i=0;i<wallpaper.length;i++){
            for (int j=0;j<wallpaper[0].length();j++){
                // x좌표 = j
                // y좌표 = i
                if(wallpaper[i].charAt(j) == '#'){
                    if (j<startX){
                        startX = j;
                    }
                    if (i<startY){
                        startY= i;
                    }
                    if (j>endX){
                        endX = j;
                    }
                    if (i>endY){
                        endY = i;
                    }
                }
            }
        }

        
        int[] answer = {startY, startX,endY+1 ,endX+1 };
        return answer;
    }
}