import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        HashMap<Integer, Double> fails = new HashMap<>();

        int remainUser = stages.length;

        for (int i = 1; i < N+1; i++) {
            int count = 0;

            for (int stage : stages) {
                if (stage == i) {
                    count++;
                }
            }
            
            
            double fail = (remainUser == 0) ? 0.0 : (count / (double) remainUser);
            remainUser -= count;
            
            fails.put(i, fail);
        }

//         List<Map.Entry<Integer, Double>> entries = new ArrayList<>(fails.entrySet());
//         entries.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        List<Integer> keySet = new ArrayList<>(fails.keySet());
        keySet.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = fails.get(o2).compareTo(fails.get(o1)); // 실패율 내림차순
                return (compare != 0) ? compare : Integer.compare(o1, o2); // 실패율이 같으면 스테이지 번호 오름차순
            }
        });

        return keySet.stream().mapToInt(Integer::intValue).toArray();
    }
}