import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> str = new ArrayList<>();
        int isPrime = 1;
        for(int i=2;i<n;i++){
            // 약수일때
            if(i==2){
            	if(n%2==0) {
            		str.add(2);
                    continue;
            	}
                
            }
            if(n%i==0){
                // 소수인지 확인
                for(int j=2;j<i;j++){
                    // 약수가 있으
                	if (i%j==0){
                		isPrime = 0;
                		break;
                    }
                }
                if(isPrime ==1) {
                	str.add(i);
                }
                else{
                    isPrime = 1;
                }
                
            }
        }
        if(str.size() == 0){
            int[] arr = new int[1];
            arr[0] = n;
            return arr;
        }
        int[] arr = new int[str.size()];
        
        for(int i=0;i<str.size();i++){
            arr[i] = str.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }
}