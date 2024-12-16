import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];
            List<Integer> tempList = new ArrayList<>();
            
            int start = array[command[0]-1];
            int end = array[command[1]-1];
            
            for(int j=command[0]-1; j<command[1]; j++){
                tempList.add(array[j]);
            }
            
            Collections.sort(tempList);
            
            answer[i] = tempList.get(command[2]-1);
        }
        
        return answer;
    }
}