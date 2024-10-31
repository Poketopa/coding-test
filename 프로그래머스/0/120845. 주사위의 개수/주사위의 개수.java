class Solution {
    public int solution(int[] box, int n) {
        int height = 0;
        int width = 0;
        int length = 0;
        
        int answer = 0;
        
        height = box[0]/n;
        width = box[1]/n;
        length = box[2]/n;
        
        return height*width*length;
    }
}