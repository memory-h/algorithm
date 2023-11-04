package implementation.silver.silver_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();

        row.add(0);
        row.add(Integer.parseInt(st.nextToken()));

        column.add(0);
        column.add(Integer.parseInt(st.nextToken()));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int rc = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // rc == 0 이면 column에 값을 넣어주고, rc == 1 이면 row에 넣어준다.
            if (rc == 0) column.add(value);
            else row.add(value);
        }
        Collections.sort(row);
        Collections.sort(column);

        int max = 0;

        // 종이를 잘랐을 때, 가장 큰 종이 조각의 넓이를 구한다.
        for (int i = 0; i < row.size() - 1; i++) {
            int rowValue = row.get(i + 1) - row.get(i);

            for (int j = 0; j < column.size() - 1; j++) {
                int columnValue = column.get(j + 1) - column.get(j);

                max = Math.max(max, rowValue * columnValue);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}