class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        // 1단계: 소문자로 치환
        answer = answer.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, -, _, . 제외한 문자 제거
        answer = answer.replaceAll("[^a-z0-9._-]", "");

        // 3단계: 마침표가 2번 이상 연속되면 하나로 치환
        answer = answer.replaceAll("\\.{2,}", ".");

        // 4단계: 마침표가 처음이나 끝에 있으면 제거
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }   

        // 5단계: 빈 문자열이면 "a" 대입
        if (answer.isBlank()) {
            answer = "a";
        }

        // 6단계: 길이가 16 이상이면 15개만 남기고, 끝의 마침표 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            while (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7단계: 길이가 2 이하라면 마지막 문자를 반복해서 길이 3 만들기
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}