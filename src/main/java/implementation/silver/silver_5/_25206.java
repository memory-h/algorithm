package implementation.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String courseName = st.nextToken(); // 과목명
            double credit = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급

            // P 등급 과목은 계산에서 제외
            if (!grade.equals("P")) {
                totalPoints += credit * getGradePoint(grade);
                totalCredits += credit;
            }
        }

        // 총점을 총 학점으로 나누어 평점 계산
        double result = totalPoints / totalCredits;

        // 소수점 아래 6자리까지 출력
        System.out.printf("%.6f", result);
    }

    private static double getGradePoint(String grade) {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F": return 0.0;
            default: return 0.0; // P 등급 또는 유효하지 않은 등급
        }
    }

}