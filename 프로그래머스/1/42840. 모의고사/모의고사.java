import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] scores = new int[3];

        // 수포자들 정답 찍기 방법
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        // 점수 계산
        for(int i = 0; i < answers.length; i++) {

            if(answers[i] == supoza1[i%supoza1.length]) {
                scores[0]++;
            }

            if(answers[i] == supoza2[i%supoza2.length]) {
                scores[1]++;
            }

            if(answers[i] == supoza3[i%supoza3.length]) {
                scores[2]++;
            }
        }
        
        // 가장 높은 점수 확인
        int max = 0;
        
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] > max) {
                max = scores[i];
            }
        }
        
        // 가장 높은 점수 번호 담기
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == max) {
                list.add(i+1);
            }
        }
        
        // 리스트->배열 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int[] solution2(int[] answers) {
        int[] ptn1 = {1, 2, 3, 4, 5};
        int[] ptn2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ptn3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    

        int[] cnt = {0,0,0,0};
        
        for(int i=0; i< answers.length; i++){
           if(answers[i] == ptn1[i%5]) cnt[1]++;
           if(answers[i] == ptn2[i%8]) cnt[2]++;
           if(answers[i] == ptn3[i%10]) cnt[3]++;                                
        }
        
        int max= Math.max(Math.max(cnt[1], cnt[2]),cnt[3]);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<4; i++){
            if(max==cnt[i]) result.add(i);
        }
        
        
        int[] resultToArr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultToArr[i] = result.get(i);            
        }
        
        return resultToArr;
    }
    
    public int[] solution3(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().orElse(0);
        
        return IntStream.range(0, scores.length)
                .filter(i -> scores[i] == maxScore)
                .map(i -> i + 1)
                .toArray();
    }
}