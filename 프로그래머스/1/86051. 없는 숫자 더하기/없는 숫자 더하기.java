class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        int temp = 0;
        for(int i : numbers) temp += i;
        return sum - temp;
    }
}