import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        return array[(len-1)/2];
    }
}