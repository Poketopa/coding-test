import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 대소문자 통합
        // 문자열 나누기 (배열 생성) (문자열 / 숫자)
        // files 정렬

        // 소문자로 통합
        String[] newFiles = new String[files.length];
        for(int i=0;i<files.length;i++){
            String temp = "";
            for(int j=0;j<files[i].length();j++){
                if('A'<=files[i].charAt(j)&&files[i].charAt(j)<='Z'){
                    temp += String.valueOf((char)(files[i].charAt(j)+32));
                }
                else{
                    temp += String.valueOf((char)(files[i].charAt(j)));
                }
            }
            newFiles[i] = temp;
        }

        String[] stringArray = new String[newFiles.length];
        int[] intArray = new int[newFiles.length];
        // 문자열 나누기
        for(int i=0;i<newFiles.length;i++){
            int index = 0;
            String temp1 = "";
            String temp2 = "";
            while(!('0'<=newFiles[i].charAt(index)&&newFiles[i].charAt(index)<='9')){
                temp1 += String.valueOf(newFiles[i].charAt(index));
                index++;
            }
            while(('0'<=newFiles[i].charAt(index)&&newFiles[i].charAt(index)<='9')){
                temp2 += String.valueOf(newFiles[i].charAt(index));
                index++;
                if(index == newFiles[i].length()) break;
            }
            stringArray[i] = temp1;
            intArray[i] = Integer.valueOf(temp2);
        }

        Integer[] sortArray = new Integer[files.length];
        for(int i=0;i<sortArray.length;i++) sortArray[i] = i;

        Arrays.sort(sortArray, (a, b)->{
            if(stringArray[(int) a].compareTo(stringArray[(int) b])<0){
                return -1;
            }
            else if(stringArray[(int) a].compareTo(stringArray[(int) b])>0){
                return 1;
            }
            else{
                if(intArray[(int)a]<intArray[(int)b]){
                    return -1;
                }
                else if(intArray[(int)a]>intArray[(int)b]){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });
        String[] answer = new String[sortArray.length];

        for(int i=0;i<sortArray.length;i++){
            answer[i] = files[sortArray[i]];
        }

        return answer;
    }
}