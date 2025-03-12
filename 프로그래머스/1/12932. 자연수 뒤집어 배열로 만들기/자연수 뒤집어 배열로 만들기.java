import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(long n) {
        if (n == 0) return new int[]{0}; // 예외 처리 추가
        
        List<Integer> list = new ArrayList<>();
        
        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}