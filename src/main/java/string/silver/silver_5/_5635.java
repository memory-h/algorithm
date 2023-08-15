package string.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
class Student {
    public String name;
    public int day, month, year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
public class _5635 {
    private static boolean isComparison(Student s1, Student s2) {
        if(s1.year != s2.year) return s1.year > s2.year;
        if(s1.month != s2.month) return s1.month > s2.month;

        return s1.day > s2.day;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Student youngest = null;
        Student oldest = null;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            Student student = new Student(name, day, month, year);

            if(youngest == null || isComparison(student, youngest)) youngest = student;
            if(oldest == null || isComparison(oldest, student)) oldest = student;
        }
        bw.write(youngest.name + "\n" + oldest.name);
        bw.flush();
        bw.close();
    }
}