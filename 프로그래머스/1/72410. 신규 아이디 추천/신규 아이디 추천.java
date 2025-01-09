import java.util.*;

class Solution {
    public String solution(String new_id) {
        char[] id1 = new char[new_id.length()];
        for(int i=0;i<id1.length;i++){
            id1[i] = new_id.charAt(i);
        }
        // 1. 대문자 -> 소문자
        for(int i=0;i<id1.length;i++){
            if('A'<=id1[i]&&id1[i]<='Z'){
                id1[i] += 32;
            }
        }
        // 2. 소문자, 숫자, 빼기, 빝줄, 마침표 빼고 제거
        for(int i=0;i<id1.length;i++){
            if('a'<=id1[i]&&id1[i]<='z') continue;
            else{
                if('0'<=id1[i]&&id1[i]<='9') continue;
                else{
                    if(id1[i] == '-' || id1[i] == '_' || id1[i] == '.') continue;
                    else{
                        id1[i] = ' ';
                    }
                }
            }
        }

        String str2 = "";
        for(int i=0;i<id1.length;i++){
            str2 += String.valueOf(id1[i]);
        }
        str2 = str2.replace(" ", "");
        char[] id2 = new char[str2.length()];
        for(int i=0;i<id2.length;i++){
            id2[i] = str2.charAt(i);
        }

        // 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        for(int i=0;i<id2.length-1;i++){
            if(id2[i] == '.' && id2[i+1] == '.'){
                id2[i] = ' ';
            }
        }

        String str3 = "";
        for(int i=0;i<id2.length;i++){
            str3 += String.valueOf(id2[i]);
        }
        str3 = str3.replace(" ", "");
        char[] id3 = new char[str3.length()];
        for(int i=0;i<id3.length;i++){
            id3[i] = str3.charAt(i);
        }


        // 4. 마침표가 처음이나 끝에 위치하면 제거
        if(id3[0] == '.') id3[0] = ' ';
        if(id3[id3.length-1] == '.') id3[id3.length-1] = ' ';

        String str4 = "";
        for(int i=0;i<id3.length;i++){
            str4 += String.valueOf(id3[i]);
        }
        str4 = str4.replace(" ", "");
        char[] id4 = new char[str4.length()];
        for(int i=0;i<id4.length;i++){
            id4[i] = str4.charAt(i);
        }
        String answer = "";
        // 5. 빈 문자열이면 a 대입
        if(str4.equals("")){
            str4 += "aaa";
            return str4;
        }
        // String 사용

        // 6. 길이가 16자 이상이면 15자까지만 출력, 제거 후 마침표가 끝에 있으면 제거
        if(id4.length>15){
            if(id4[14] == '.'){
                for(int i=0;i<14;i++){
                    answer += String.valueOf(id4[i]);
                }
            }
            else{
                for(int i=0;i<15;i++){
                    answer += String.valueOf(id4[i]);
                }
            }
        }
        // 7. 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복
        else if(id4.length<3){
            for(int i=0;i<id4.length;i++){
                answer += String.valueOf(id4[i]);
            }
            while(answer.length()<3){
                answer += String.valueOf(id4[id4.length-1]);
            }
        }
        else{
            for(int i=0;i<id4.length;i++){
                answer += String.valueOf(id4[i]);
            }
        }
        return answer;
    }
}