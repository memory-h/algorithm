package string.bronze.bronze_3;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class _28454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 현재 날짜 읽기
        LocalDate currentDate = LocalDate.parse(br.readLine(), dateTimeFormatter);

        int n = Integer.parseInt(br.readLine());
        int gifticonCount = 0;

        // 각 기프티콘의 유효기간 확인
        for (int i = 0; i < n; i++) {
            LocalDate gifticon = LocalDate.parse(br.readLine(), dateTimeFormatter);

            if (!currentDate.isAfter(gifticon)) gifticonCount++;
        }
        bw.write(gifticonCount + "\n");
        bw.flush();
        bw.close();
    }
}