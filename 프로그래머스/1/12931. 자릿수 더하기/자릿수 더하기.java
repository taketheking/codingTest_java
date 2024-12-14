import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(true){
            if(n/10 != 0){
                answer += n%10;
            }
            else{
                answer += n;
                break;
            }
            
            n /= 10;
        }

        
        return answer;
    }
}