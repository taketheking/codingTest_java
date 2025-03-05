import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 1. 문자열을 다중집합 원소 배열로 만든다.
        // 2. 특수 문자가 있으면 제외
        // 3. 대문자와 소문자 구분 x
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String element = str1.toLowerCase().substring(i, i+2);
            if(element.matches("^[a-z]+$")) {
                str1List.add(element);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String element = str2.toLowerCase().substring(i, i+2);
            if(element.matches("^[a-z]+$")) {
                str2List.add(element);
            }
        }
        
        if(str1List.size() == 0 && str2List.size() == 0) {
            return 65536;
        }

        // 4. 교집합 계산
        // 5. 합집합 계산
        // 6. 교집합/합집합
        List<String> unionStrList = new ArrayList<>();
        List<String> intersectionStrList = new ArrayList<>();
        
        for(String str : str1List) {
            if(str2List.remove(str)) {
                intersectionStrList.add(str);
            }
            unionStrList.add(str);
        }
        
        for(String str : str2List) {
            unionStrList.add(str);
        }
        
        // 7. 리턴
        double a = intersectionStrList.size();
        double b = unionStrList.size();
    
        if(b == 0) {
            return 65536;
        }
        
        return (int) (a/b * 65536);
    }
}