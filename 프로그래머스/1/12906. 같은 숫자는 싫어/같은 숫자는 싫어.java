import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        
        int preNumber = arr[0];
        list.add(preNumber);
        
        for(int num : arr){
            if(preNumber != num){
                list.add(num);
                preNumber = num;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}