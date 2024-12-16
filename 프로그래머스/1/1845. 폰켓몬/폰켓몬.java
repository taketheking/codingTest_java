import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num : nums){
            set.add(num);
        }
        
        if(set.size() > nums.length/2){
            return nums.length/2;
        }
        
        return set.size();
    }
}