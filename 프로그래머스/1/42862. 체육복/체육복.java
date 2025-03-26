import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        // 현재 들을 수 있는 사람
        int student = n - lost.length;
        
        lost = Arrays.stream(lost).sorted().toArray();
        reserve = Arrays.stream(reserve).sorted().toArray();

        // 1. 본인의 여벌 체육복을 먼저 확인
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) { // 본인이 여벌 체육복을 가지고 있는 경우
                    student++;
                    lost[i] = -1;  // 처리된 학생 표시
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 2. 앞뒤 학생에게 체육복 빌리기
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue; // 이미 본인 체육복을 사용한 경우 건너뜀

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue; // 이미 사용된 여벌 체육복 건너뜀

                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) { // 앞뒤 학생 확인
                    student++;
                    reserve[j] = -1; // 체육복 사용 처리
                    break;
                }
            }
        }

        
        return student;
    }
}