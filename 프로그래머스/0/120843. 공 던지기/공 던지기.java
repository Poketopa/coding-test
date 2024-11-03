class Solution {
    public int solution(int[] numbers, int k) {
        int count = 0;
        
        for(int i=0;i<k-1;i++){
            count+=2;
        }
        return numbers[count%(numbers.length)];
        
    }
}