import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] scores = new int[3];

        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


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

        if(scores[0] > scores[1]) {
            if(scores[0] > scores[2]) {
                return new int[]{1};
            } else if (scores[0] == scores[2]) {
                return new int[]{1, 3};
            }
            else {
                return new int[]{3};
            }
        }
        else if (scores[0] == scores[1]){
            if(scores[0] > scores[2]) {
                return new int[]{1, 2};
            } else if (scores[0] == scores[2]) {
                return new int[]{1, 2, 3};
            }
            else {
                return new int[]{3};
            }
        }
        else {
            if(scores[1] > scores[2]) {
                return new int[]{2};
            }
            else if (scores[1] == scores[2]) {
                return new int[]{2,3};
            }
            else {
                return new int[]{3};
            }
        }
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