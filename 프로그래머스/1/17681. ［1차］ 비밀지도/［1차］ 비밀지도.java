import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 1. 이진법으로 변환
        // 2. 한 줄씩 겹쳐서 벽과 공백으로 문자열 구성
        // 3. String[]에 넣기
        
        String[] arr1ToBinary = new String[arr1.length];

        for(int i=0; i<n; i++) {
            int num = arr1[i];
            String temp = "";

            for(int j=0; j<n; j++) {
                temp = (num % 2) + temp;
                num = num/2;
            }
            
            arr1ToBinary[i] = temp;
        }
        
        String[] arr2ToBinary = new String[arr2.length];

        for(int i=0; i<n; i++) {
            int num = arr2[i];
            String temp = "";

            for(int j=0; j<n; j++) {
                temp = (num % 2) + temp;
                num = num/2;
            }

            arr2ToBinary[i] = temp;
        }
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();

            for(int j= 0; j<n; j++) {
                if(arr1ToBinary[i].charAt(j) == '1' || arr2ToBinary[i].charAt(j) == '1') {
                    
                    temp.append("#");
                }
                else{
                    temp.append(" ");
                }
            }
            
            answer[i] = temp.toString();
        }
        
        
        return answer;
    }
}
